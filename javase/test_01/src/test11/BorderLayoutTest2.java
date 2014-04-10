package test11;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextField;

public class BorderLayoutTest2 {
	public static void main(String[] args) {
		Frame f = new Frame("test window");
		f.setLayout(new BorderLayout(30, 5));
		f.add(new Button("南"), BorderLayout.SOUTH);
		f.add(new Button("北"), BorderLayout.NORTH);
		Panel panel = new Panel();
		panel.add(new TextField(20));
		panel.add(new Button("click me"));
		f.add(panel);
		f.add(new Button("东"), BorderLayout.EAST);
		f.pack();
		f.setVisible(true);
	}
}
