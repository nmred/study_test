package test11;

import java.awt.CheckboxMenuItem;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.MenuShortcut;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.event.MenuEvent;

public class SimpleMenu {
	private Frame frame = new Frame("test window");
	private MenuBar mBar = new MenuBar();
	Menu fileMenu = new Menu("File");
	Menu editMenu = new Menu("Edit");
	MenuItem newItem = new MenuItem("Create");
	MenuItem saveiItem = new MenuItem("Save");
	MenuItem exitItem = new MenuItem("Exit", new MenuShortcut(KeyEvent.VK_X));
	CheckboxMenuItem autoItem = new CheckboxMenuItem("auto line");
	MenuItem copyItem = new MenuItem("Copy");
	MenuItem pasteItem = new MenuItem("Paste");
	Menu formatMenu = new Menu("Format");
	MenuItem commentiItem = new MenuItem("Comment", new MenuShortcut(KeyEvent.VK_SLASH, true));
	MenuItem cancelCommentItem = new MenuItem("Cancel comment");
	
	private TextArea tArea = new TextArea(6, 40);
	
	public void init() {
		ActionListener menuActionListener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String cmdString = e.getActionCommand();
				tArea.append("click" + cmdString + "menu\n");
				if (cmdString.equals("Exit")) {
					System.exit(0);
				}
				
			}
		};
		
		commentiItem.addActionListener(menuActionListener);
		exitItem.addActionListener(menuActionListener);
		
		fileMenu.add(newItem);
		fileMenu.add(saveiItem);
		fileMenu.add(exitItem);
		editMenu.add(autoItem);
		editMenu.addSeparator();
		editMenu.add(copyItem);
		editMenu.add(pasteItem);
		formatMenu.add(commentiItem);
		formatMenu.add(cancelCommentItem);
		editMenu.add(new MenuItem("-"));
		editMenu.add(formatMenu);
		mBar.add(fileMenu);
		mBar.add(editMenu);
		frame.setMenuBar(mBar);
		frame.add(tArea);
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		frame.pack();
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		new SimpleMenu().init();
	}
}
