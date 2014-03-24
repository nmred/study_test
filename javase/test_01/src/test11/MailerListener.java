package test11;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MailerListener implements ActionListener{
	private TextField mailAddressField ;
	
	public MailerListener() {}
	
	public MailerListener (TextField mailField) {
		this.mailAddressField = mailField;
	}
	
	public void actionPerformed(ActionEvent e) {
		System.out.println("project send mail.");
	}
}
