package test11;

import java.awt.BorderLayout;
import java.awt.CheckboxMenuItem;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.MenuShortcut;
import java.awt.Panel;
import java.awt.PopupMenu;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class PopupMenuTest {
	private TextArea tArea = new TextArea(4, 30);
	private Frame f = new Frame("test");
	PopupMenu popupMenu = new PopupMenu();
	CheckboxMenuItem autoWarp = new CheckboxMenuItem("auto line");
	MenuItem copyiItem = new MenuItem("copy");
	MenuItem pasteItem = new MenuItem("paste");
	Menu formatMenu = new Menu("format");
	MenuItem commentItem = new MenuItem("comment", new MenuShortcut(KeyEvent.VK_SLASH, true));
	MenuItem cancelItem = new MenuItem("cancel comment");
	
	public void init() {
		ActionListener menuActionListener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String cmd = e.getActionCommand();
				tArea.append("click " + cmd + " menu\n");
				if (cmd.equals("exit")) {
					System.exit(0);
				}
			}
		};
		
		commentItem.addActionListener(menuActionListener);
		popupMenu.add(autoWarp);
		popupMenu.addSeparator();
		popupMenu.add(copyiItem);
		popupMenu.add(pasteItem);
		formatMenu.add(commentItem);
		formatMenu.add(cancelItem);
		popupMenu.add(new MenuItem("-"));
		popupMenu.add(formatMenu);
		final Panel panel = new Panel();
		panel.setPreferredSize(new Dimension(300, 160));
		panel.add(popupMenu);
		
		panel.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					popupMenu.show(panel, e.getX(), e.getY());
				}
			}
		});
		f.add(panel);
		f.add(tArea, BorderLayout.NORTH);
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		f.pack();
		f.setVisible(true);
	}
	
	public static void main(String[] args) {
		new PopupMenuTest().init();
	}
}
