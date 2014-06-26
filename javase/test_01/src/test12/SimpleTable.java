package test12;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class SimpleTable {
	JFrame jf = new JFrame("简单表格");
	JTable table;
	
	Object[][] tableData =
	{
		new Object[]{"李清照", 29, "女"},
		new Object[]{"苏格拉底", 56, "男"},
		new Object[]{"李白", 35, "男"},
		new Object[]{"弄玉", 18, "女"},
		new Object[]{"虎头", 2, "男"}
	};
	
	Object[] columnTitle = {"姓名", "年龄", "性别"};
	public void init()
	{
		table = new JTable(tableData, columnTitle);
		jf.add(new JScrollPane(table));
		jf.pack();
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
	}
	
	public static void main(String[] args)
	{
		new SimpleTable().init();
	}
}
