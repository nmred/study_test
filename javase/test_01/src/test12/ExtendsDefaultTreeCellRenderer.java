package test12;

import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

public class ExtendsDefaultTreeCellRenderer {
	JFrame jf = new JFrame("根据节点类型定义图标");
	JTree tree;
	DefaultMutableTreeNode root = new DefaultMutableTreeNode(new NodeData(DBObjectType.ROOT, "数据库导航"));
	DefaultMutableTreeNode salaryDb = new DefaultMutableTreeNode(new NodeData(DBObjectType.DATABASE, "公司工资数据库"));
	DefaultMutableTreeNode customerDb = new DefaultMutableTreeNode(new NodeData(DBObjectType.DATABASE, "公司客户数据库"));
	DefaultMutableTreeNode employee = new DefaultMutableTreeNode(new NodeData(DBObjectType.TABLE, "员工表"));
	DefaultMutableTreeNode attend = new DefaultMutableTreeNode(new NodeData(DBObjectType.TABLE, "考勤表"));
	DefaultMutableTreeNode contact = new DefaultMutableTreeNode(new NodeData(DBObjectType.TABLE, "联系方式表"));
	DefaultMutableTreeNode id = new DefaultMutableTreeNode(new NodeData(DBObjectType.INDEX, "员工ID"));
	DefaultMutableTreeNode name = new DefaultMutableTreeNode(new NodeData(DBObjectType.COLUMN, "姓名"));
	DefaultMutableTreeNode gender = new DefaultMutableTreeNode(new NodeData(DBObjectType.COLUMN, "性别 "));
	
	public void init()
	{
		root.add(salaryDb);
		root.add(customerDb);
		salaryDb.add(employee);
		salaryDb.add(attend);
		customerDb.add(contact);
		employee.add(id);
		employee.add(name);
		employee.add(gender);
		
		tree = new JTree(root);
		tree.setCellRenderer(new MyRenderer());
		tree.setShowsRootHandles(true);
		tree.setRootVisible(true);
		jf.add(new JScrollPane(tree));
		jf.pack();
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
	}
	
	public static void main(String[] args)
	{
		new ExtendsDefaultTreeCellRenderer().init();
	}
	
	class NodeData
	{
		public int nodeType;
		public String nodeData;
		
		public NodeData(int nodeType, String nodeData)
		{
			this.nodeType = nodeType;
			this.nodeData = nodeData;
		}
		
		public String toString()
		{
			return nodeData;
		}
	}

	interface DBObjectType
	{
		int ROOT = 0;
		int DATABASE = 1;
		int TABLE    = 2;
		int COLUMN   = 3;
		int INDEX    = 4;
	}
	
	class MyRenderer extends DefaultTreeCellRenderer
	{
		ImageIcon rootIcon = new ImageIcon("image/root.gif");
		ImageIcon databaseIcon = new ImageIcon("image/database.gif");
		ImageIcon tableIcon = new ImageIcon("image/table.gif");
		ImageIcon columnIcon = new ImageIcon("image/column.gif");
		ImageIcon indexIcon = new ImageIcon("image/index.gif");
		
		public Component getTreeCellRendererComponent(
				JTree tree,
				Object value,
				boolean sel,
				boolean expanded,
				boolean leaf,
				int row,
				boolean hasFocus)
		{
			super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);
			DefaultMutableTreeNode node = (DefaultMutableTreeNode)value;
			NodeData data = (NodeData)node.getUserObject();
			ImageIcon icon = null;
			switch (data.nodeType) {
			case DBObjectType.ROOT:
				icon = rootIcon;
				break;
			case DBObjectType.DATABASE:
				icon = databaseIcon;
				break;
			case DBObjectType.INDEX:
				icon = indexIcon;
				break;
			case DBObjectType.TABLE:
				icon = tableIcon;
				break;
			case DBObjectType.COLUMN:
				icon = columnIcon;
				break;
			
			}
			this.setIcon(icon);
			return this;
		}
	}
}
