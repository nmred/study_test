package test11;

import java.awt.Button;
import java.awt.Frame;

import javax.swing.BoxLayout;

public class BoxlayoutTest {
	private Frame f = new Frame("test window");
	public void init() {
		f.setLayout(new BoxLayout(f, BoxLayout.Y_AXIS));
		f.add(new Button("one"));
		f.add(new Button("two"));
		f.pack();
		f.setVisible(true);
	}
	public static void main(String[] args) {
		new BoxlayoutTest().init();
	}
}
