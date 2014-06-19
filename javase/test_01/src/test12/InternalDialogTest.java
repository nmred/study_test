package test12;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class InternalDialogTest {
	private JFrame jf = new JFrame("测试内部对话框");
	private JDesktopPane desktop = new JDesktopPane();
	
	private JButton internalBn = new JButton("内部窗口的对话框");
	private JButton deskBn = new JButton("虚拟桌面的对话框");
	
	private JInternalFrame iframe = new JInternalFrame("内部窗口");
	public void init()
	{
		iframe.add(new JScrollPane(new JTextArea(8, 40)));
		desktop.setPreferredSize(new Dimension(400, 300));
		jf.add(desktop);
		iframe.reshape(0, 0, 300, 200);
		iframe.show();
		desktop.add(iframe);
		
		JPanel jp = new JPanel();
		deskBn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showInternalConfirmDialog(desktop, "属于虚拟桌面的对话框");
			}
		});
		
		internalBn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showInternalConfirmDialog(iframe, "属于内部窗口的对话框");
			}
		});
		jp.add(deskBn);
		jp.add(internalBn);
		jf.add(jp, BorderLayout.SOUTH);
		jf.pack();
		jf.setVisible(true);
	}
	
	public static void main(String[] args)
	{
		new InternalDialogTest().init();
	}
}
