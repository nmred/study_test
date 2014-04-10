package test11;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.TextField;

public class GridLayoutTest {
	public static void main(String[] args) {
		Frame frame = new Frame("test window");
		Panel p1 = new Panel();
		p1.add(new TextField(30));
		frame.add(p1, BorderLayout.NORTH);
		Panel p2 = new Panel();
		p2.setLayout(new GridLayout(3, 5, 4, 4));
		String[] nameStrings = {
				"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "+", "-", "*", "/", "."
		};
		for (int i = 0; i < nameStrings.length; i++) {
			p2.add(new Button(nameStrings[i]));
		}
		frame.add(p2);
		frame.pack();
		frame.setVisible(true);
	}
}
