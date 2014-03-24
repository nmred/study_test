package test11;

import java.awt.Frame;
import java.awt.TextArea;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class SimpleEventHandler extends WindowAdapter{
	private Frame frame = new Frame("test");
	private TextArea tArea = new TextArea(6, 40);
	public void windowClosing(WindowEvent e) {
		System.out.println("用户窗口关闭\n");
		System.exit(0);
	}
	
	public void init() {
		frame.add(tArea);
		frame.addWindowListener(this);
		frame.pack();
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		new SimpleEventHandler().init();
	}
}
