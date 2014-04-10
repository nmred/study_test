package test11;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;

public class FlowLayoutTest {
	public static void  main(String[] args) {
		Frame frame = new Frame("test window");
		frame.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 5));
		for (int i = 0; i < 10; i++) {
			frame.add(new Button("button" + i));
		}
		
		frame.pack();
		frame.setVisible(true);
	}
}
