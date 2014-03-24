package test11;

import java.awt.Frame;
import java.awt.TextArea;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class WindowAdapterTest {
	private Frame frame = new Frame("test window.");
	private TextArea tArea = new TextArea(6, 40);
	public void init() {
		frame.addWindowListener(new MyListener());
		frame.add(tArea);
		frame.pack();
		frame.setVisible(true);
	}
	
	class MyListener extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			System.out.println("用户窗口关闭\n");
			System.exit(0);
		}
	}
	
	public static void main(String[] args) {
		new WindowAdapterTest().init();
		
	}
}
