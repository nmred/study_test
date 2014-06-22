package test12;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ListTest {
	private JFrame mainWin = new JFrame("测试列表框");
	String[] books = new String[]
	{
			"疯狂Java讲义",
			"轻量级Java EE企业应用实战",
			"疯狂Ajax讲义",
			"经典Java EE企业应用实战"
	};
	JList<String> bookList = new JList<>(books);
	JComboBox<String> bookSelector;
	
	JPanel layoutPanel = new JPanel();
	ButtonGroup layoutGroup = new ButtonGroup();
	JPanel selectModePanel = new JPanel();
	ButtonGroup selectModeGroup = new ButtonGroup();
	
	JTextArea favoriate = new JTextArea(4, 40);
	
	public void init()
	{
		bookList.setVisibleRowCount(3);
		bookList.setSelectionInterval(2, 4);
		addLayoutButton("纵向滚动", JList.VERTICAL);
		addLayoutButton("纵向换行", JList.VERTICAL_WRAP);
		addLayoutButton("横向换行", JList.HORIZONTAL_WRAP);
		addSelectModeButton("无限制", ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		addSelectModeButton("单选", ListSelectionModel.SINGLE_SELECTION);
		addSelectModeButton("单范围", ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		
		Box listBox = new Box(BoxLayout.Y_AXIS);
		listBox.add(new JScrollPane(bookList));
		listBox.add(layoutPanel);
		listBox.add(selectModePanel);
	
		bookList.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				List<String> books = bookList.getSelectedValuesList();
				favoriate.setText("");
				for(String book : books) {
					favoriate.append(book + "\n");
				}
			}
		});
		
		Vector<String> bookCollection = new Vector<>();
		bookCollection.add("疯狂Java讲义");
		bookCollection.add("轻量级Java EE 企业应用实战");
		bookCollection.add("疯狂Ajax讲义");
		bookCollection.add("经典Java EE 企业应用实战");
		
		bookSelector = new JComboBox<>(bookCollection);
		bookSelector.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Object book = bookSelector.getSelectedItem();
				favoriate.setText(book.toString());
			}
		});
		
		bookSelector.setEditable(true);
		bookSelector.setMaximumRowCount(4);
		
		JPanel p = new JPanel();
		p.add(bookSelector);
		
		Box box = new Box(BoxLayout.X_AXIS);
		box.add(listBox);
		box.add(p);
		
		mainWin.add(box);
		JPanel favoriatePanel = new JPanel();
		favoriatePanel.setLayout(new BorderLayout());
		favoriatePanel.add(new JScrollPane(favoriate));
		favoriatePanel.add(new JLabel("您喜欢的图书"), BorderLayout.NORTH);
		mainWin.add(favoriatePanel, BorderLayout.SOUTH);
		mainWin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWin.pack();
		mainWin.setVisible(true);	
	}
	
	private void addLayoutButton(String label, final int orientation)
	{
		layoutPanel.setBorder(new TitledBorder(new EtchedBorder(), "确定选项布局"));
		JRadioButton button = new JRadioButton(label);
		layoutPanel.add(button);
		if (layoutGroup.getButtonCount() == 0) {
			button.setSelected(true);
		}
		layoutGroup.add(button);
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				bookList.setLayoutOrientation(orientation);
			}
		});
	}
	
	private void addSelectModeButton(String label, final int selectModel)
	{
		selectModePanel.setBorder(new TitledBorder(new EtchedBorder(), "确定选择模式"));
		JRadioButton button = new JRadioButton(label);
		selectModePanel.add(button);
		if (selectModeGroup.getButtonCount() == 0) {
			button.setSelected(true);
		}
		selectModeGroup.add(button);
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				bookList.setSelectionMode(selectModel);
			}
		});
	}
	
	public static void main(String[] args)
	{
		new ListTest().init();
	}
}
