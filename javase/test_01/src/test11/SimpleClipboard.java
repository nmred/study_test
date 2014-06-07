package test11;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.Box;
import javax.swing.BoxLayout;

public class SimpleClipboard {
	private Frame f = new Frame("简单的剪切板程序");
	private Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
	private TextArea jtaCopyTo = new TextArea(5, 20);
	private TextArea jtaPaste  = new TextArea(5, 20);
	
	private Button btCopy = new Button("复制");
	private Button btPaste = new Button("粘贴");
	
	public void init()
	{
		Panel p = new Panel();
		p.add(btCopy);
		p.add(btPaste);
		btCopy.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				StringSelection contents = new StringSelection(jtaCopyTo.getText());
				clipboard.setContents(contents, null);
			}
		});
		
		btPaste.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent event) {
				if (clipboard.isDataFlavorAvailable(DataFlavor.stringFlavor)) {
					try {
						String content = (String)clipboard.getData(DataFlavor.stringFlavor);
						jtaPaste.append(content);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
		
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		Box box = new Box(BoxLayout.X_AXIS);
		box.add(jtaCopyTo);
		box.add(jtaPaste);
		f.add(p, BorderLayout.SOUTH);
		f.add(box, BorderLayout.CENTER);
		f.pack();
		f.setVisible(true);
	}
	
	public static void main(String[] args)
	{
		new SimpleClipboard().init();
	}
}
