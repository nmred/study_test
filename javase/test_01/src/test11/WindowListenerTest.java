package test11;

import java.awt.Frame;
import java.awt.TextArea;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class WindowListenerTest {
	private Frame frame = new Frame("test window");
	private TextArea tArea = new TextArea(6, 40);
	public void init() {
		frame.addWindowListener(new MyListener());
		frame.add(tArea);
		frame.pack();
		frame.setVisible(true);
	}
	
	class MyListener implements WindowListener {
		public void windowOpened(WindowEvent e) {
			tArea.append("window opened.\n");
		}
		
		public void windowClosing(WindowEvent e) {
			tArea.append("window closing.\n");
			System.exit(0);
		}
		
		public void windowClosed(WindowEvent e) {
			tArea.append("window success closed.\n");
		}
		
		public void windowIconified(WindowEvent e) {
			tArea.append("window mined.\n");
		}
		
		public void windowDeiconified(WindowEvent e) {
			tArea.append("window recover.\n");
		}
		
		public void windowActivated(WindowEvent e) {
			tArea.append("window actived.\n");
		}
		
		public void windowDeactivated(WindowEvent e) {
			tArea.append("window lose action.\n");
		}
	}
	
	public static void main(String[] args) {
		new WindowListenerTest().init();
		
	}
}
