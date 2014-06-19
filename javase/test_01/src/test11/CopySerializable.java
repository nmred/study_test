package test11;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CopySerializable {
	Frame f = new Frame("复制对象");
	Button copy = new Button("复制");
	Button paste = new Button("粘贴");
	TextField name = new TextField(15);
	TextField age  = new TextField(15);
	TextArea ta    = new TextArea(3, 30);
	Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
	
	public void init()
	{
		Panel p = new Panel();
		p.add(new Label("姓名"));
		p.add(name);
		p.add(new Label("年龄"));
		p.add(age);
		f.add(p, BorderLayout.NORTH);
		f.add(ta);
		
		Panel bp = new Panel();
		copy.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				copyDog();
			}
		});
		paste.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					readDog();
				} catch (Exception exception) {
					exception.printStackTrace();
				}
			}
		});
		
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		bp.add(copy);
		bp.add(paste);
		f.add(bp, BorderLayout.SOUTH);
		f.pack();
		f.setVisible(true);
	}
	
	public void copyDog()
	{
		Dog d = new Dog(name.getText(), Integer.parseInt(age.getText()));
		SerialSelection ls = new SerialSelection(d);
		clipboard.setContents(ls, null);
	}
	
	public void readDog() throws Exception
	{
		DataFlavor dogDataFlavor = new DataFlavor(DataFlavor.javaSerializedObjectMimeType + ";class=test11.Dog");
		if (clipboard.isDataFlavorAvailable(DataFlavor.stringFlavor)) {
			Dog d = (Dog)clipboard.getData(dogDataFlavor);
			ta.setText(d.toString());
		}
	}
	
	public static void main(String[] args)
	{
		new CopySerializable().init();
	}
}
