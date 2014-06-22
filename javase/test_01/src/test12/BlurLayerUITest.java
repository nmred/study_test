package test12;


import java.awt.Graphics;
import java.awt.Graphics2D;
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
import javax.swing.plaf.LayerUI;

public class BlurLayerUITest {
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
		
		LayerUI<JComponent> layerUI = new BlurLayterUI1();
		JLayer<JComponent> layer = new JLayer<JComponent>(panel, layerUI);
		
		frame.add(layer);
		frame.setSize(300, 170);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public static void main(String[] args)
	{
		new BlurLayerUITest().init();
	}
}

class BlurLayterUI1 extends LayerUI<JComponent>
{
	private BufferedImage screeBufferedImage;
	private BufferedImageOp operation;
	
	public BlurLayterUI1()
	{
		float ninth = 1.0f / 9.0f;
		float[] blurKernal = {
			ninth, ninth, ninth,
			ninth, ninth, ninth,
			ninth, ninth, ninth
		};
		operation = new ConvolveOp(new Kernel(3, 3, blurKernal), ConvolveOp.EDGE_NO_OP, null);
	}
	
	public void paint(Graphics g, JComponent c) {
		int w = c.getWidth();
		int h = c.getHeight();
		if (w == 0 || h == 0) {
			return;
		}
		if (screeBufferedImage == null
			|| screeBufferedImage.getWidth() != w
			|| screeBufferedImage.getHeight() != h) {
			screeBufferedImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
		}
		Graphics2D ig2 = screeBufferedImage.createGraphics();
		ig2.setClip(g.getClip());
		super.paint(ig2, c);
		ig2.dispose();
		Graphics2D g2 = (Graphics2D)g;
		g2.drawImage(screeBufferedImage, operation, 0, 0);
	}
}