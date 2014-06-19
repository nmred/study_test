package test12;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SwingDndSupport {
	JFrame jf = new JFrame("Swing 的拖放支持");
	JTextArea srcTextArea = new JTextArea(8, 30);
	JTextField jtf = new JTextField(34);
	
	public void init()
	{
		srcTextArea.append("Swing 的拖放支持.\n");
		srcTextArea.append("将该文本域的内容拖入其他程序.\n");
		srcTextArea.setDragEnabled(true);
		jtf.setDragEnabled(true);
		jf.add(new JScrollPane(srcTextArea));
		jf.add(jtf, BorderLayout.SOUTH);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.pack();
		jf.setVisible(true);
	}
	
	public static void main(String[] args)
	{
		new SwingDndSupport().init();
	}
}
