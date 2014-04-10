package test11;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

public class TestFont {
	JFrame jFrame = new JFrame("测试");
	JButton jbtnButton = new JButton("发送");
	
	public void init() {
		jFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
 		});
		jFrame.add(jbtnButton);
		jFrame.pack();
		jFrame.setVisible(true);
	}
	
	public static void  main(String[] args) {
		new TestFont().init();
		
	}
}
