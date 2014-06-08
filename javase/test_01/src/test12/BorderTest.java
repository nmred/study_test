package test12;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;

public class BorderTest {
	private JFrame f = new JFrame("测试边框");
	
	public void init()
	{
		f.setLayout(new GridLayout(2, 4));
		Border bb = BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.RED, Color.GREEN, Color.BLUE, Color.GRAY);
		f.add(getPanelWithBorder(bb, "BevelBorder"));
		
		Border lb = BorderFactory.createLineBorder(Color.ORANGE, 10);
		f.add(getPanelWithBorder(lb, "LineBorder"));
		
		Border eb = BorderFactory.createEmptyBorder(20, 5, 10, 30);
		f.add(getPanelWithBorder(eb, "EmptyBorder"));
		
		Border etb = BorderFactory.createEtchedBorder(EtchedBorder.RAISED, Color.RED, Color.GREEN);
		f.add(getPanelWithBorder(etb, "EtchedBorder"));
		
		TitledBorder tb = new TitledBorder(lb, "测试标题", TitledBorder.LEFT, TitledBorder.BOTTOM, new Font("StSong", Font.BOLD, 18), Color.BLUE);
		f.add(getPanelWithBorder(tb, "TitledBorder"));
		
		MatteBorder mb = new MatteBorder(20, 5, 10, 30, Color.GREEN);
		f.add(getPanelWithBorder(mb, "MatteBorder"));
		
		CompoundBorder cb = new CompoundBorder(new LineBorder(Color.RED, 8), tb);
		f.add(getPanelWithBorder(cb, "CompoundBorder"));
		f.pack();
		f.setVisible(true);
	}
	
	public JPanel getPanelWithBorder(Border b, String BorderName)
	{
		JPanel p = new JPanel();
		p.add(new Label(BorderName));
		p.setBorder(b);
		return p;
	}
	
	public static void main(String[] args)
	{
		new BorderTest().init();
	}
}
