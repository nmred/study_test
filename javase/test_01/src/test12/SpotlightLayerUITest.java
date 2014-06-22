package test12;


import java.awt.AWTEvent;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RadialGradientPaint;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLayer;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;
import javax.swing.plaf.LayerUI;

public class SpotlightLayerUITest {
	public void init()
	{
		JFrame frame = new JFrame("JLayer 测试");
		JPanel panel = new JPanel();
		ButtonGroup group = new ButtonGroup();
		JRadioButton radioButton;
		
		panel.add(radioButton = new JRadioButton("网购购买", true));
		group.add(radioButton);
		panel.add(radioButton = new JRadioButton("书店购买"));
		group.add(radioButton);
		panel.add(radioButton = new JRadioButton("图书馆借阅"));
		group.add(radioButton);
		
		panel.add(new JCheckBox("疯狂Java讲义"));
		panel.add(new JCheckBox("疯狂 Android 讲义"));
		panel.add(new JCheckBox("疯狂 Ajax 讲义"));
		panel.add(new JCheckBox("轻量级Java EE 企业应用"));
		
		JButton orderButton = new JButton("投票");
		panel.add(orderButton);
		
		LayerUI<JComponent> layerUI = new SpotlightLayerUI();
		JLayer<JComponent> layer = new JLayer<JComponent>(panel, layerUI);
		
		frame.add(layer);
		frame.setSize(300, 170);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public static void main(String[] args)
	{
		new SpotlightLayerUITest().init();
	}
}

class SpotlightLayerUI extends LayerUI<JComponent>
{
	private boolean active;
	private int cx, cy;
	public void installUI(JComponent c)
	{
		super.installUI(c);
		JLayer layer = (JLayer)c;
		layer.setLayerEventMask(AWTEvent.MOUSE_EVENT_MASK | AWTEvent.MOUSE_MOTION_EVENT_MASK);
	}
	
	public void uninstallUI(JComponent c)
	{
		JLayer layer = (JLayer)c;
		layer.setLayerEventMask(0);
		super.uninstallUI(c);
	}
	
	public void paint(Graphics g, JComponent c)
	{
		Graphics2D g2 = (Graphics2D)g.create();
		super.paint(g2, c);
		if (active) {
			Point2D center = new Point2D.Float(cx, cy);
			float raduis = 72;
			float[] dist = {0.0f, 1.0f};
			Color[] colors = {Color.YELLOW, Color.BLACK};
			RadialGradientPaint p = new RadialGradientPaint(center, raduis, dist, colors);
			g2.setPaint(p);
			g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, .6f));
			g2.fillRect(0, 0, c.getWidth(), c.getHeight());
		}
		g2.dispose();
	}
	
	public void processMouseEvent(MouseEvent e, JLayer layer) 
	{
		if (e.getID() == MouseEvent.MOUSE_ENTERED) {
			active = true;
		}
		if (e.getID() == MouseEvent.MOUSE_EXITED) {
			active = false;
		}
		
		layer.repaint();
	}
	
	public void processMouseMotionEvent(MouseEvent e, JLayer layer)
	{
		Point p = SwingUtilities.convertPoint(e.getComponent(), e.getPoint(), layer);
		cx = p.x;
		cy = p.y;
		layer.repaint();
	}
}