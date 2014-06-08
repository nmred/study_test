package test12;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

public class BindKeyTest {
	JFrame jf = new JFrame("测试键盘测试");
	JTextArea jta = new JTextArea(5, 30);
	JButton jb = new JButton("发送");
	
	JTextField jtf = new JTextField(15);
	
	public void init()
	{
		jf.add(jta);
		JPanel jp = new JPanel();
		jp.add(jtf);
		jp.add(jb);
		jf.add(jp, BorderLayout.SOUTH);
		
		Action sendMsg = new AbstractAction() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				jta.append(jtf.getText() + "\n");
				jtf.setText("");
			}
		};
		
		jb.addActionListener(sendMsg);
		jtf.getInputMap().put(KeyStroke.getKeyStroke('\n', InputEvent.CTRL_MASK), "send");
		
		jtf.getActionMap().put("send", sendMsg);
		jf.pack();
		jf.setVisible(true);
	}
	
	public static void main(String[] args)
	{
		new BindKeyTest().init();
	}
}
