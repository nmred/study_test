package test11;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;

public class BorderLayoutTest {
	public static void main(String[] args) {
		Frame fr = new Frame("test window");
		fr.setLayout(new BorderLayout(30, 5));
		fr.add(new Button("south"), BorderLayout.SOUTH);
		fr.add(new Button("north"), BorderLayout.NORTH);
		fr.add(new Button("center"));
		fr.add(new Button("east"), BorderLayout.EAST);
		fr.add(new Button("west"), BorderLayout.WEST);
		
		fr.pack();
		fr.setVisible(true);
	}
}
