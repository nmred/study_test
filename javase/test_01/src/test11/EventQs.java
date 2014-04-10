package test11;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventQs {
	private Frame frame = new Frame("test window");
	private Button okButton = new Button("confirm");
	private TextField tField = new TextField(30);
	public void init() {
		okButton.addActionListener(new Oklistener());
		frame.add(tField);
		frame.add(okButton, BorderLayout.SOUTH);
		frame.pack();
		frame.setVisible(true);
	}
	
	class Oklistener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.out.println("user click ok button");
			tField.setText("Hello world");
		}
	}
	
	public static void main(String[] args) {
		new EventQs().init();
	}
}
