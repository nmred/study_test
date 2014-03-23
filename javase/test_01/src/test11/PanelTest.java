package test11;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextField;


public class PanelTest {
	public static void main(String[] args) {
		Frame frame = new Frame("测试窗口");
		Panel p = new Panel();
		p.add(new TextField(20));
		Button btnButton = new Button("click");
		p.add(btnButton);
		frame.add(p);
		frame.setBounds(30, 30, 250, 120);
		frame.setVisible(true);
	}
}
