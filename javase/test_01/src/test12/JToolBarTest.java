package test12;

import java.awt.BorderLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;

public class JToolBarTest {
	JFrame f = new JFrame("测试工具条");
	JTextArea jta = new JTextArea(6, 35);
	JToolBar jtb = new JToolBar();
	JMenuBar jmb = new JMenuBar();
	JMenu edit = new JMenu("编辑");
	
	Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
	Action pasteAction = new AbstractAction("粘贴", new ImageIcon("image/paste.png")) {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if (clipboard.isDataFlavorAvailable(DataFlavor.stringFlavor)) {
				try {
					String contents = (String)clipboard.getData(DataFlavor.stringFlavor);
					jta.replaceRange(contents, jta.getSelectionStart(), jta.getSelectionEnd());
					
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
	};
	
	Action copyAction = new AbstractAction("复制", new ImageIcon("image/copy.png")) {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			StringSelection contents = new StringSelection(jta.getSelectedText());
			clipboard.setContents(contents, null);
			if (clipboard.isDataFlavorAvailable(DataFlavor.stringFlavor)) {
				pasteAction.setEnabled(true);
			}
		}
	};
	
	public void init()
	{
		pasteAction.setEnabled(false);
		f.add(new JScrollPane(jta));
		
		JButton copyBtn = new JButton(copyAction);
		JButton pasteBtn = new JButton(pasteAction);
		JPanel jp = new JPanel();
		jp.add(copyBtn);
		jp.add(pasteBtn);
		f.add(jp, BorderLayout.SOUTH);
		
		jtb.add(copyAction);
		jtb.addSeparator();
		jtb.add(pasteAction);
		
		edit.add(copyAction);
		edit.add(pasteAction);
		
		jmb.add(edit);
		f.setJMenuBar(jmb);
		
		jtb.setMargin(new Insets(20, 10, 5, 30));
		f.add(jtb, BorderLayout.NORTH);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.pack();
		f.setVisible(true);		
		
	}
	
	public static void main(String[] args)
	{
		new JToolBarTest().init();
	}
}
