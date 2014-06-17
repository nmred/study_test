package test12;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class JTabbedPaneTest {
	JFrame jf = new JFrame("测试Tab页面");
	JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT, JTabbedPane.WRAP_TAB_LAYOUT);
	ImageIcon icon = new ImageIcon("image/close.gif");
	
	String[] layouts = {"换行布局", "滚动条布局"};
	String[] positions = {"左边", "顶部", "右边", "底部"};
	Map<String, String> books = new LinkedHashMap<>();
	
	public void init()
	{
		books.put("疯狂Java讲义", "image/1.gif");
		books.put("疯狂Java讲义1", "image/2.gif");
		books.put("疯狂Java讲义2", "image/3.gif");
		books.put("疯狂Java讲义3", "image/4.gif");
		books.put("疯狂Java讲义4", "image/black.gif");
		String tip = "可看到本书的封面照片";
		
		for (String bookName : books.keySet()) {
			tabbedPane.addTab(bookName, icon, null, tip);
		}
		
		jf.add(tabbedPane, BorderLayout.CENTER);
		
		tabbedPane.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				if (tabbedPane.getSelectedComponent() == null) {
					int n = tabbedPane.getSelectedIndex();
					loadTab(n);
				}
				
			}
		});
		loadTab(0);
		tabbedPane.setPreferredSize(new Dimension(500, 300));
		
		JPanel buttJPanel = new JPanel();
		ChangeAction action = new ChangeAction();
		buttJPanel.add(new ButtonPanel(action, "选择标签布局位置", layouts));
		buttJPanel.add(new ButtonPanel(action, "选择标签位置", positions));
		
		jf.add(buttJPanel, BorderLayout.SOUTH);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.pack();
		jf.setVisible(true);
	}
	
	private void loadTab(int n)
	{
		String title = tabbedPane.getTitleAt(n);
		ImageIcon bookimImage = new ImageIcon(books.get(title));
		tabbedPane.setComponentAt(n, new JLabel(bookimImage));
		tabbedPane.setIconAt(n, new ImageIcon("image/open.gif"));
	}
	
	public static void main(String[] args)
	{
		new JTabbedPaneTest().init();
	}
	
	class ChangeAction implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			JRadioButton source = (JRadioButton)e.getSource();
			String selection = source.getActionCommand();
			
			if (selection.equals(layouts[0])) {
				tabbedPane.setTabLayoutPolicy(JTabbedPane.WRAP_TAB_LAYOUT);
			} else if (selection.equals(layouts[1])) {
				tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
			} else if (selection.equals(positions[0])) {
				tabbedPane.setTabPlacement(JTabbedPane.LEFT);
			} else if (selection.equals(positions[1])) {
				tabbedPane.setTabPlacement(JTabbedPane.TOP);
			} else if (selection.equals(positions[2])) {
				tabbedPane.setTabPlacement(JTabbedPane.RIGHT);
			} else {
				tabbedPane.setTabPlacement(JTabbedPane.BOTTOM);
			}
		}
	}
	
	class ButtonPanel extends JPanel
	{
		private ButtonGroup group;
		public ButtonPanel(JTabbedPaneTest.ChangeAction action, String title, String[] labels)
		{
			setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), title));
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			group = new ButtonGroup();
			for(int i = 0; labels != null && i < labels.length; i++) {
				JRadioButton b = new JRadioButton(labels[i]);
				b.setActionCommand(labels[i]);
				add(b);
				b.addActionListener(action);
				group.add(b);
				b.setSelected(i == 0);
			}
		}
	}
}
