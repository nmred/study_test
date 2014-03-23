package test11;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;

import javax.swing.Box;

public class BoxSpaceTest {
	private Frame f = new Frame("test win");
	private Box horizontal = Box.createHorizontalBox();
	private Box vertical = Box.createVerticalBox();
	
	public void init() {
		horizontal.add(new Button("hor one"));
		horizontal.add(Box.createHorizontalGlue());
		horizontal.add(new Button("hor two"));
		horizontal.add(Box.createHorizontalStrut(10));
		horizontal.add(new Button("hor third"));
		
		vertical.add(new Button("ver one"));
		vertical.add(Box.createVerticalGlue());
		vertical.add(new Button("ver two"));
		vertical.add(Box.createVerticalStrut(10));
		vertical.add(new Button("ver third"));
		f.add(horizontal, BorderLayout.NORTH);
		f.add(vertical);
		f.pack();
		f.setVisible(true);
	}
	
	public static void main(String[] args) {
		new BoxSpaceTest().init();
	}
}
