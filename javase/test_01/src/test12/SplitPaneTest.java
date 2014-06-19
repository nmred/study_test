package test12;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class SplitPaneTest {
	Book[] books = new Book[]{
			new Book("疯狂Java讲义", new ImageIcon("image/new.png"), "国内关于Java编程最全面的图书\n看得懂"),
			new Book("轻量级Java EE 企业应用实战", new ImageIcon("image/open.png"), "SSH整合开发的图书，值得拥有"),
			new Book("疯狂Android讲义", new ImageIcon("image/ok.png"), "Android")
	};
	
	JFrame jf = new JFrame("测试JSplitPane");
	JList<Book> bookList = new JList<SplitPaneTest.Book>(books);
	JLabel bookCover = new JLabel();
	JTextArea bookDesc = new JTextArea();
	
	public void init()
	{
		bookList.setPreferredSize(new Dimension(150, 300));
		bookCover.setPreferredSize(new Dimension(300, 150));
		bookDesc.setPreferredSize(new Dimension(300, 150));
		
		bookList.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				Book book = (Book)bookList.getSelectedValue();
				bookCover.setIcon(book.getIcon());
				bookDesc.setText(book.getDesc());
			}
		});
		
		JSplitPane left = new JSplitPane(JSplitPane.VERTICAL_SPLIT, true, bookCover, new JScrollPane(bookDesc));
		left.setOneTouchExpandable(true);
		left.resetToPreferredSizes();
		JSplitPane content = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, left, bookList);
		jf.add(content);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.pack();
		jf.setVisible(true);
	}
	
	public static void main(String[] args)
	{
		new SplitPaneTest().init();
	}
	
	class Book
	{
		private String name;
		private ImageIcon icon;
		private String desc;
		
		public Book(String name, ImageIcon icon, String desc)
		{
			this.name = name;
			this.icon = icon;
			this.desc = desc;
		}
		
		public ImageIcon getIcon()
		{
			return this.icon;
		}
		
		public String getDesc()
		{
			return this.desc;
		}
		
		public String toString()
		{
			return this.name;
		}
	}
}
