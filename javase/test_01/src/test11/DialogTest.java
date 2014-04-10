package test11;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DialogTest {
	Frame f = new Frame("test window");
	Dialog d1 = new Dialog(f, "module", true);
	Dialog d2 = new Dialog(f, "no module", false);
	Button b1 = new Button("open d1 window.");
	Button b2 = new Button("open d2 window.");
	
	public void init() {
		d1.setBounds(20, 30, 300, 400);
		d2.setBounds(20, 30, 300, 400);
		b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				d1.setVisible(true);
			}
		});
		b2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				d2.setVisible(true);
			}
		});
		
		f.add(b1);
		f.add(b2, BorderLayout.SOUTH);
		f.pack();
		f.setVisible(true);
	}
	
	public static void main(String[] args) {
		new DialogTest().init();
	}
}
