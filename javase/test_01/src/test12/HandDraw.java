package test12;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;

import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

public class HandDraw {
	private final int AREA_WIDTH  = 500;
	private final int AREA_HEIGHT = 400;
	
	private int preX = -1;
	private int preY = -1;
	
	JPopupMenu pop = new JPopupMenu();
	JMenuItem chooseColor = new JMenuItem("选择颜色");
	
	BufferedImage image = new BufferedImage(AREA_WIDTH, AREA_HEIGHT, BufferedImage.TYPE_INT_RGB);
	Graphics g = image.getGraphics();
	
	private JFrame jf = new JFrame("简单手绘程序");
	private DrawCanvas drawArea = new DrawCanvas();
	private Color foreColor = new Color(255, 0, 0);
	
	public void init()
	{
		chooseColor.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				final JColorChooser colorPane = new JColorChooser(foreColor);
				JDialog jd = JColorChooser.createDialog(jf, "选择画笔颜色", false, colorPane, new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						foreColor = colorPane.getColor();
					}
				}, null);
				jd.setVisible(true);
			}
		});
		
		pop.add(chooseColor);
		drawArea.setComponentPopupMenu(pop);
		g.fillRect(0, 0, AREA_WIDTH, AREA_HEIGHT);
		drawArea.setPreferredSize(new Dimension(AREA_WIDTH, AREA_HEIGHT));
		drawArea.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				if (preX > 0 && preY > 0) {
					g.setColor(foreColor);
					g.drawLine(preX, preY, e.getX(), e.getY());
				}
				preX = e.getX();
				preY = e.getY();
				drawArea.repaint();
			}
		});
		
		drawArea.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				preX = -1;
				preY = -1;
			}
		});
		jf.add(drawArea);
		jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
		jf.pack();
		jf.setVisible(true);
	}
	
	public static void main(String[] args)
	{
		new HandDraw().init();
	}
	
	class DrawCanvas extends JPanel
	{
		public void paint(Graphics g)
		{
			g.drawImage(image, 0, 0, null);
		}
	}
}
