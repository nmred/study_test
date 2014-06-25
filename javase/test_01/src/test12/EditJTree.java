package test12;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
public class EditJTree {
	JFrame jf = new JFrame("简单数");
	JTree tree;
	DefaultTreeModel model;
	DefaultMutableTreeNode root;
	DefaultMutableTreeNode guangdong;
	DefaultMutableTreeNode guangxi;
	DefaultMutableTreeNode foshan;
	DefaultMutableTreeNode shantou;
	DefaultMutableTreeNode guilin;
	DefaultMutableTreeNode nanning;
	
	TreePath movePath;
	JButton addSibingButton = new JButton("添加兄弟节点");
	JButton addChildButton  = new JButton("添加子节点");
	JButton deleteButton    = new JButton("删除节点");
	JButton editButton      = new JButton("编辑当前节点");
	
	public void init()
	{
		root = new DefaultMutableTreeNode("中国");
		guangdong = new DefaultMutableTreeNode("广东");
		guangxi = new DefaultMutableTreeNode("广西");
		foshan  = new DefaultMutableTreeNode("佛山");
		shantou = new DefaultMutableTreeNode("汕头");
		guilin  = new DefaultMutableTreeNode("桂林");
		nanning = new DefaultMutableTreeNode("南宁");
		
		guangdong.add(foshan);
		guangdong.add(shantou);
		guangxi.add(nanning);
		guangxi.add(guilin);
		root.add(nanning);
		root.add(guangdong);
		root.add(guangxi);
		
		tree = new JTree(root);
		model = (DefaultTreeModel)tree.getModel();
		tree.setEditable(true);
		
		MouseListener ml = new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				TreePath tp = tree.getPathForLocation(e.getX(), e.getY());
				if (tp != null) {
					movePath = tp;
				}
			}
			
			public void mouseReleased(MouseEvent e) {
				TreePath tp = tree.getPathForLocation(e.getX(), e.getY());
				if (tp != null && movePath != null) {
					if (movePath.isDescendant(tp) && movePath != tp) {
						JOptionPane.showMessageDialog(jf, "目标节点是被移动节点的子节点,无法移动!", "非法操作", JOptionPane.ERROR_MESSAGE);
						return;
					} else if (movePath != tp) {
						((DefaultMutableTreeNode)tp.getLastPathComponent()).add((DefaultMutableTreeNode)movePath.getLastPathComponent());
						movePath = null;
						tree.updateUI();
					}
				}
			}
		};
		tree.addMouseListener(ml);
		JPanel panel = new JPanel();
		addSibingButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode)tree.getLastSelectedPathComponent();
				if (selectedNode == null) return;
				DefaultMutableTreeNode parent = (DefaultMutableTreeNode)selectedNode.getParent();
				if (parent == null) return;
				
				DefaultMutableTreeNode newNode = new DefaultMutableTreeNode("新节点");
				int selectedIndex = parent.getIndex(selectedNode);
				model.insertNodeInto(newNode, parent, selectedIndex + 1);
				TreeNode[] nodes = model.getPathToRoot(newNode);
				TreePath path = new TreePath(nodes);
				tree.scrollPathToVisible(path);
			}
		});
		panel.add(addSibingButton);
		
		addChildButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode)tree.getLastSelectedPathComponent();
				if (selectedNode == null) return;
				DefaultMutableTreeNode newNode = new DefaultMutableTreeNode("新节点");
				selectedNode.add(newNode);
				TreeNode[] nodes = model.getPathToRoot(newNode);
				TreePath path = new TreePath(nodes);
				tree.scrollPathToVisible(path);
				tree.updateUI();
			}
		});
		panel.add(addChildButton);
		
		deleteButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode)tree.getLastSelectedPathComponent();
				if (selectedNode != null && selectedNode.getParent() != null) {
					model.removeNodeFromParent(selectedNode);
				}
			}
		});
		panel.add(deleteButton);
		
		editButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				TreePath selectedPath = tree.getSelectionPath();
				if (selectedPath != null) {
					tree.startEditingAtPath(selectedPath);
				}
			}
		});
		panel.add(editButton);
		
		jf.add(new JScrollPane(tree));
		jf.add(panel, BorderLayout.SOUTH);
		jf.pack();
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
	}
	
	public static void main(String[] args)
	{
		new EditJTree().init();
	}
}
