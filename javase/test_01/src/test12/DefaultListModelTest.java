package test12;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

public class DefaultListModelTest {
	private JFrame mainWin = new JFrame("测试DefaultListModel");
	private JList<String>bookList;
	private DefaultListModel<String> bookModel = new DefaultListModel<>();
	private JTextField bookName = new JTextField(20);
	private JButton removeBn = new JButton("删除选中图书");
	private JButton addBn = new JButton("添加指定图书");
	
	public void init()
	{
		bookModel.addElement("疯狂Java讲义");
		bookModel.addElement("轻量级Java EE 企业应用实战");
		bookModel.addElement("疯狂Android 讲义");
		bookModel.addElement("疯狂Ajax讲义");
		bookModel.addElement("经典Java EE企业应用实战");
		
		bookList = new JList<>(bookModel);
		bookList.setVisibleRowCount(4);
		bookList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		addBn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (!bookName.getText().trim().equals("")) {
					bookModel.addElement(bookName.getText());
				}
			}
		});
		
		removeBn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (bookList.getSelectedIndex() >= 0) {
					bookModel.removeElementAt(bookList.getSelectedIndex());
				}
			}
		});
		
		JPanel p = new JPanel();
		p.add(bookName);
		p.add(addBn);
		p.add(removeBn);
		
		mainWin.add(new JScrollPane(bookList));
		mainWin.add(p, BorderLayout.SOUTH);
		mainWin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWin.pack();
		mainWin.setVisible(true);
	}
	
	public static void main(String[] args)
	{
		new DefaultListModelTest().init();
	}
}
