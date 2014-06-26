package test12;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeCellRenderer;

public class CustomTreeNode {
	JFrame jf = new JFrame("定制树的节点");
	JTree tree;
	
	DefaultMutableTreeNode friends = new DefaultMutableTreeNode("我的好友");
	DefaultMutableTreeNode qingzhao = new DefaultMutableTreeNode("李清照");
	DefaultMutableTreeNode suge     = new DefaultMutableTreeNode("苏格拉底");
	DefaultMutableTreeNode libai    = new DefaultMutableTreeNode("李白");
	DefaultMutableTreeNode nongyu   = new DefaultMutableTreeNode("弄玉");
	DefaultMutableTreeNode hutou    = new DefaultMutableTreeNode("虎头");
	
	public void init()
	{
		friends.add(qingzhao);
		friends.add(suge);
		friends.add(libai);
		friends.add(nongyu);
		friends.add(hutou);
		
		tree = new JTree(friends);
		tree.setShowsRootHandles(true);
		tree.setRootVisible(true);
		tree.setCellRenderer(new ImageCellRenderer());
		
		jf.add(new JScrollPane(tree));
		jf.pack();
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
	}
	
	public static void main(String[] args)
	{
		new CustomTreeNode().init();
	}
	
	class ImageCellRenderer extends JPanel implements TreeCellRenderer
	{
		private ImageIcon icon;
		private String name;
		private Color background;
		private Color foreground;
		
		public  Component getTreeCellRendererComponent(
				JTree tree,
				Object value,
				boolean sel,
				boolean expanded,
				boolean leaf,
				int row,
				boolean hasFocus)
		{
			icon = new ImageIcon("image/" + value + ".gif");
			name = value.toString();
			background = hasFocus ? new Color(140, 200, 235) : new Color(255, 255, 255);
			foreground = hasFocus ? new Color(255, 255, 3) : new Color(0, 0, 0);
			
			return this;
		}
		
		public void paintComponent(Graphics g)
		{
			int imageWidth = icon.getImage().getWidth(null);
			int imageHeight = icon.getImage().getHeight(null);
			g.setColor(background);
			g.fillRect(0, 0, getWidth(), getHeight());
			g.setColor(foreground);
			g.drawImage(icon.getImage(), getWidth() / 2 - imageWidth / 2, 10, null);
			g.setFont(new Font("SansSerif", Font.BOLD, 18));
			g.drawString(name, getWidth() / 2 - name.length() * 10, imageHeight + 30);
		}
		
		public Dimension getPreferredSize()
		{
			return new Dimension(80, 80);
		}
	}
}
