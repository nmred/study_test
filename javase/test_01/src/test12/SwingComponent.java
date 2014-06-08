package test12;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class SwingComponent {
	JFrame f = new JFrame("测试");
	Icon okIcon = new ImageIcon("image/ok.png");
	JButton ok = new JButton("确认", okIcon);
	
	JRadioButton male = new JRadioButton("男", true);
	JRadioButton female = new JRadioButton("女", false);
	ButtonGroup bg = new ButtonGroup();
	
	JCheckBox married = new JCheckBox("是否已婚？", false);
	String[] colors = new String[]{"红色", "绿色", "蓝色"};
	JComboBox<String> colorChooser = new JComboBox<>(colors);
	JList<String> colorList = new JList<>(colors);
	JTextArea ta = new JTextArea(8, 20);
	JTextField name = new JTextField(40);
	
	JMenuBar mb = new JMenuBar();
	JMenu file = new JMenu("文件");
	JMenu edit = new JMenu("编辑");
	
	Icon newIcon = new ImageIcon("image/new.png");
	JMenuItem newItem = new JMenuItem("新建", newIcon);
	JMenuItem saveItem = new JMenuItem("保存", new ImageIcon("image/save.png"));
	JMenuItem exitItem = new JMenuItem("退出", new ImageIcon("image/exit.png"));
	
	JCheckBoxMenuItem autoWrap = new JCheckBoxMenuItem("自动换行");
	
	JMenuItem copyItem = new JMenuItem("复制", new ImageIcon("image/copy.png"));
	JMenuItem pasteItem = new JMenuItem("粘贴", new ImageIcon("image/paste.png"));
	JMenu format = new JMenu("格式");
	JMenuItem commentItem = new JMenuItem("注释");
	JMenuItem cancelItem = new JMenuItem("取消注释");
	
	JPopupMenu pop = new JPopupMenu();
	ButtonGroup flavorGroup = new ButtonGroup();
	JRadioButtonMenuItem metalItem = new JRadioButtonMenuItem("Metal 风格", true);
	JRadioButtonMenuItem nimbusItem = new JRadioButtonMenuItem("Nimbus 风格");
	JRadioButtonMenuItem windowsItem = new JRadioButtonMenuItem("windows 风格");
	JRadioButtonMenuItem classicItem = new JRadioButtonMenuItem("windows 经典风格");
	JRadioButtonMenuItem motifItem = new JRadioButtonMenuItem("Motif 风格");
	
	public void init()
	{
		JPanel bottom = new JPanel();
		bottom.add(name);
		bottom.add(ok);
		f.add(bottom, BorderLayout.SOUTH);
		
		JPanel checkJPanel = new JPanel();
		checkJPanel.add(colorChooser);
		bg.add(male);
		bg.add(female);
		checkJPanel.add(male);
		checkJPanel.add(female);
		checkJPanel.add(married);
		
		
		// 创建一个垂直的组件
		Box topLeft = Box.createVerticalBox();
		JScrollPane taJsp = new JScrollPane(ta);
		topLeft.add(taJsp);
		topLeft.add(checkJPanel);
		
		// 创建一个水平的组件
		Box top = Box.createHorizontalBox();
		top.add(topLeft);
		top.add(colorList);
		
		f.add(top);
		
		newItem.setAccelerator(KeyStroke.getKeyStroke('N', InputEvent.CTRL_MASK));
		newItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ta.append("用户点击了新建菜单");	
			}
		});
		
		
		file.add(newItem);
		file.add(saveItem);
		file.add(exitItem);
		
		edit.add(autoWrap);
		edit.addSeparator();
		edit.add(copyItem);
		edit.add(pasteItem);
		commentItem.setToolTipText("将程序代码注释起来");
		format.add(commentItem);
		format.add(cancelItem);
		edit.add(format);
		
		mb.add(file);
		mb.add(edit);
		
		f.setJMenuBar(mb);
		flavorGroup.add(metalItem);
		flavorGroup.add(nimbusItem);
		flavorGroup.add(windowsItem);
		flavorGroup.add(classicItem);
		flavorGroup.add(motifItem);
		pop.add(metalItem);
		pop.add(nimbusItem);
		pop.add(windowsItem);
		pop.add(classicItem);
		pop.add(motifItem);
		
		ActionListener flavorListener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					switch (e.getActionCommand()) {
					case "Metal 风格":
						changeFlavor(1);
						break;
					case "Nimbus 风格":
						changeFlavor(2);
						break;
					case "windows 风格":
						changeFlavor(3);
						break;
					case "windows 经典风格":
						changeFlavor(4);
						break;
					case "Motif 风格":
						changeFlavor(5);
						break;
					}
				} catch (Exception exception) {
					exception.printStackTrace();
				}
			}
		};
		
		metalItem.addActionListener(flavorListener);
		nimbusItem.addActionListener(flavorListener);
		windowsItem.addActionListener(flavorListener);
		classicItem.addActionListener(flavorListener);
		motifItem.addActionListener(flavorListener);
		
		ta.setComponentPopupMenu(pop);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.pack();
		f.setVisible(true);
	}
	
	private void changeFlavor(int flavor) throws Exception
	{
		switch (flavor) {
		case 1:
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
			break;
		case 2:
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
			break;
		case 3:
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			break;
		case 4:
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
			break;
		case 5:
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
			break;
		}
		
		SwingUtilities.updateComponentTreeUI(f.getContentPane());
		SwingUtilities.updateComponentTreeUI(mb);
		SwingUtilities.updateComponentTreeUI(pop);
	}
	
	public static void main(String[] args)
	{
		new SwingComponent().init();
	}
}
