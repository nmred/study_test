package test11;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;

import javax.swing.Box;

public class BoxTest {
	private Frame f = new Frame("test window");
	private Box horizontalBox = Box.createHorizontalBox();
	private Box vertzontalBox = Box.createVerticalBox();
	
	public void init() {
		horizontalBox.add(new Button("hor one"));
		horizontalBox.add(new Button("hor two"));
		vertzontalBox.add(new Button("ver one"));
		vertzontalBox.add(new Button("ver two"));
		f.add(horizontalBox, BorderLayout.NORTH);
		f.add(vertzontalBox);
		f.pack();
		f.setVisible(true);
	}
	
	public static void main(String[] args) {
		new BoxTest().init();
	}
}
