package test12;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

public class ChangeAllCellRender {
	JFrame jf = new JFrame("改变所有节点的外观");
	JTree tree;
	
	DefaultMutableTreeNode root = new DefaultMutableTreeNode("中国");
	DefaultMutableTreeNode guangdong = new DefaultMutableTreeNode("广东");
	DefaultMutableTreeNode guangxi   = new DefaultMutableTreeNode("广西");
	DefaultMutableTreeNode foshan    = new DefaultMutableTreeNode("佛山");
	DefaultMutableTreeNode shantou   = new DefaultMutableTreeNode("汕头");
	DefaultMutableTreeNode guilin    = new DefaultMutableTreeNode("桂林");
	DefaultMutableTreeNode nanning   = new DefaultMutableTreeNode("南宁");
	
	public void init()
	{
		guangdong.add(foshan);
		guangdong.add(shantou);
		guangxi.add(nanning);
		guangxi.add(guilin);
		root.add(guangdong);
		root.add(guangxi);
		tree = new JTree(root);
		DefaultTreeCellRenderer cellRenderer = new DefaultTreeCellRenderer();
		cellRenderer.setBackground(new Color(220, 220, 220));
		cellRenderer.setBackgroundSelectionColor(new Color(140, 140, 140));
		cellRenderer.setBorderSelectionColor(Color.BLACK);
		cellRenderer.setClosedIcon(new ImageIcon("image/close.gif"));
		cellRenderer.setFont(new Font("SansSerif", Font.BOLD, 16));
		cellRenderer.setLeafIcon(new ImageIcon("image/leaf.png"));
		cellRenderer.setOpenIcon(new ImageIcon("image/open.gif"));
		cellRenderer.setTextNonSelectionColor(new Color(255, 0, 0));
		cellRenderer.setTextSelectionColor(new Color(0, 0, 255));
		tree.setCellRenderer(cellRenderer);
		tree.setRootVisible(true);
		jf.add(new JScrollPane(tree));
		jf.pack();
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
	}
	
	public static void main(String[] args)
	{
		new ChangeAllCellRender().init();
	}
}
