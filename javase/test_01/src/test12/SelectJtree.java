package test12;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;

public class SelectJtree {
	JFrame jf = new JFrame("监听树的选择事件");
	JTree tree;
	DefaultMutableTreeNode root;
	DefaultMutableTreeNode guangdong;
	DefaultMutableTreeNode guangxi;
	DefaultMutableTreeNode foshan;
	DefaultMutableTreeNode shantou;
	DefaultMutableTreeNode guilin;
	DefaultMutableTreeNode nanning;
	
	JTextArea exentTxt = new JTextArea(5, 20);
	
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
		tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		
		tree.addTreeSelectionListener(new TreeSelectionListener() {
			
			@Override
			public void valueChanged(TreeSelectionEvent e) {
				if (e.getOldLeadSelectionPath() != null) {
					exentTxt.append("原选中的节点路劲：" + e.getOldLeadSelectionPath().toString() + "\n");
					exentTxt.append("新选中的节点路劲：" + e.getNewLeadSelectionPath().toString() + "\n");
				}				
			}
		});
		
		tree.setShowsRootHandles(true);
		tree.setRootVisible(true);
		Box box = new Box(BoxLayout.X_AXIS);
		box.add(new JScrollPane(tree));
		box.add(new JScrollPane(exentTxt));
		jf.add(box);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.pack();
		jf.setVisible(true);
	}
	
	public static void main(String[] args)
	{
		new SelectJtree().init();
	}
}
