package test12;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class JLayeredPaneTest {
	JFrame jf = new JFrame("测试JLayeredPane");
	JLayeredPane layeredPane = new JLayeredPane();
	
	public void init()
	{
		layeredPane.add(new ContentPanel(10, 20, "疯狂Java讲义", "image/male.png"), JLayeredPane.MODAL_LAYER);
		layeredPane.add(new ContentPanel(100, 60, "疯狂Android讲义", "image/female.png"), JLayeredPane.DEFAULT_LAYER);
		layeredPane.add(new ContentPanel(190, 120, "轻量级Java EE企业应用实战", "image/copy.png"), 4);
		layeredPane.setPreferredSize(new Dimension(400, 300));
		jf.add(layeredPane);
		jf.pack();
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
	}
	
	public static void main(String[] args)
	{
		new JLayeredPaneTest().init();
	}
	
	class ContentPanel extends JPanel
	{
		public ContentPanel(int xPos, int yPos, String title, String ico)
		{
			setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), title));
			JLabel jLabel = new JLabel(new ImageIcon(ico));
			add(jLabel);
			setBounds(xPos, yPos, 160, 220);
		}
	}
}
