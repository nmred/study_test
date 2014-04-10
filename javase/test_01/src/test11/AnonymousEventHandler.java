package test11;

import java.awt.Frame;
import java.awt.TextArea;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AnonymousEventHandler {
	private Frame frame = new Frame("test");
	private TextArea taArea = new TextArea(4, 60);
	
	public void  init() {
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		frame.add(taArea);
		frame.pack();
		frame.setVisible(true);
	}
	
	public static void  main(String[] args) {
		new AnonymousEventHandler().init();
	}
}
