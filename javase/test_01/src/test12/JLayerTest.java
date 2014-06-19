package test12;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLayer;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.plaf.LayerUI;

public class JLayerTest {
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
		
		LayerUI<JComponent> layerUI = new FirstLayerUI();
		JLayer<JComponent> layer = new JLayer<JComponent>(panel, layerUI);
		
		frame.add(layer);
		frame.setSize(300, 170);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public static void main(String[] args)
	{
		new JLayerTest().init();
	}
}

class FirstLayerUI extends LayerUI<JComponent>
{
	public void paint(Graphics g, JComponent c) {
		super.paint(g, c);
		Graphics2D graphics2d = (Graphics2D) g.create();
		graphics2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, .5f));
		graphics2d.setPaint(new GradientPaint(0, 0, Color.RED, 0, c.getHeight(), Color.BLUE));
		graphics2d.fillRect(0, 0, c.getWidth(), c.getHeight());
		graphics2d.dispose();
	}
}