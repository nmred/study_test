package test12;

import java.awt.BorderLayout;

import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.TransferHandler;

public class TransferHandlerTest {
	private JFrame jFrame = new JFrame("测试TransferHandler\n");
	JColorChooser chooser = new JColorChooser();
	JTextArea txTextArea = new JTextArea("测试TransferHander\n"
			+ "直接将上面颜色拖入以改变文本颜色");
	
	public void init()
	{
		chooser.setDragEnabled(true);
		txTextArea.setDragEnabled(true);
		jFrame.add(chooser, BorderLayout.SOUTH);
		txTextArea.setTransferHandler(new TransferHandler("foreground"));
		jFrame.add(new JScrollPane(txTextArea));
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.pack();
		jFrame.setVisible(true);
	}
	
	public static void main(String[] args)
	{
		new TransferHandlerTest().init();
	}
	
}
