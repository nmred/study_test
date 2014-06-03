package test11;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

public class SimpleDraw {
	private final String RECT_SHAPE = "rect";
	private final String OVAL_SHAPE = "oval";
	private Frame f = new Frame("简单绘图");
	private Button rectButton = new Button("绘制矩形");
	private Button ovalButton = new Button("绘制圆形");
	private MyCanvas drawArea = new MyCanvas();
	private String shape = "";
	
	public void init()
	{
		Panel p = new Panel();
		rectButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				shape = RECT_SHAPE;
				drawArea.repaint();
			}
		});
		ovalButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				shape = OVAL_SHAPE;
				drawArea.repaint();
			}
		});
		
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		p.add(rectButton);
		p.add(ovalButton);
		drawArea.setPreferredSize(new Dimension(250, 180));
		f.add(drawArea);
		f.add(p, BorderLayout.SOUTH);
		f.pack();
		f.setVisible(true);
	}
	
	public static void  main(String[] args)
	{
		new SimpleDraw().init();
	}
	class MyCanvas extends Canvas
	{
		public void paint(Graphics g)
		{
			Random random = new Random();
			if (shape.equals(RECT_SHAPE)) {
				g.setColor(new Color(220, 100, 80));
				g.drawRect(random.nextInt(200), random.nextInt(100), 40, 60);
			}
			if (shape.equals(OVAL_SHAPE)) {
				g.setColor(new Color(80, 100, 200));
				g.fillOval(random.nextInt(200), random.nextInt(120), 50, 40);
			}
		}
	}
}
