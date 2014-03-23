package test11;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CardLayoutTest {
	Frame f = new Frame("test window");
	String[] names = {"one", "two", "thrid", "four", "5"};
	Panel plPanel = new Panel();
	
	public void init() {
		final CardLayout cardLayout = new CardLayout();
		plPanel.setLayout(cardLayout);
		for (int i = 0; i < names.length; i++) {
			plPanel.add(new Button(names[i]));
		}
		Panel p = new Panel();
		Button previous = new Button("prev");
		previous.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cardLayout.previous(plPanel);
			}
		});
		Button next = new Button("next");
		next.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cardLayout.next(plPanel);
			}
		});
		Button first = new Button("first");
		first.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cardLayout.first(plPanel);
			}
		});
		Button last = new Button("last");
		last.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cardLayout.last(plPanel);
			}
		});
		Button third = new Button("thrid");
		third.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cardLayout.show(plPanel, "thrid");
			}
		});
		
		p.add(previous);
		p.add(next);
		p.add(first);
		p.add(last);
		p.add(third);
		f.add(plPanel);
		f.add(p, BorderLayout.SOUTH);
		f.pack();
		f.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new CardLayoutTest().init();
	}
}
