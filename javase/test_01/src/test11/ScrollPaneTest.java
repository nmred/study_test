package test11;

import java.awt.Button;
import java.awt.Frame;
import java.awt.ScrollPane;
import java.awt.TextField;

public class ScrollPaneTest {
	public static void main(String[] args) {
		Frame f = new Frame("test window");
		ScrollPane spPane = new ScrollPane(ScrollPane.SCROLLBARS_ALWAYS);
		spPane.add(new TextField(20));
		spPane.add(new Button("click me"));
		f.add(spPane);
		f.setBounds(30, 30, 250, 120);
		f.setVisible(true);
	}
}
