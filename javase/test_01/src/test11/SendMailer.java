package test11;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class SendMailer {
	private Frame frame = new Frame("test window");
	private TextField tField = new TextField(40);
	private Button btnButton = new Button("send");
	public void  init() {
		btnButton.addActionListener(new MailerListener());
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		frame.add(tField);
		frame.add(btnButton, BorderLayout.SOUTH);
		frame.pack();
		frame.setVisible(true);
	}
	
	
	public static void main(String[] args) {
		new SendMailer().init();
	}
}
