package test11;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MultiListener {
	private Frame frame = new Frame("test window");
	private TextArea tArea = new TextArea(6, 40);
	private Button b1 = new Button("button 1");
	private Button b2 = new Button("button 2");
	public void  init() {
		FirstListener f1 = new FirstListener();
		b1.addActionListener(f1);
		b1.addActionListener(new SecondListener());
		b2.addActionListener(f1);
		
		frame.add(tArea);
		Panel panel = new Panel();
		panel.add(b1);
		panel.add(b2);
		frame.add(panel, BorderLayout.SOUTH);
		frame.pack();
		frame.setVisible(true);
	}
	
	class FirstListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			tArea.append("first event is action, source is " + e.getActionCommand() + "\n");
		}
	}
	
	
	class SecondListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			tArea.append("click " + e.getActionCommand() + " button\n");
		}
	}
	
	public static void  main(String[] args) {
		new MultiListener().init();	
	}
}
