package test12;

import java.beans.PropertyVetoException;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;

public class JInternalFrameTest {
	final int DESKTOP_WIDTH = 480;
	final int DESKTOP_HEIGTH = 360;
	final int FRAME_DISTANCE = 30;
	
	JFrame jf = new JFrame("MDI 界面");
	
	class MyJDesktopPane extends JDesktopPane
	{
		public void cascadeWindows(int offset, double scale)
		{
			int width = (int)(getWidth() *scale);
			int heigth = (int)(getHeight() * scale);
			int x = 0;
			int y = 0;
			for (JInternalFrame frame : getAllFrames()) {
				try {
					frame.setMaximum(false);
					frame.setIcon(false);
					frame.reshape(x, y, width, heigth);
					x += offset;
					y += offset;
					if (x + width > getWidth()) x = 0;
					if (y + heigth > getHeight()) y = 0;
				} catch (PropertyVetoException e) {
					// noting todo
				}
			}
		}
		
		public void titleWindows()
		{
			int frameCount = 0;
			for (JInternalFrame frame : getAllFrames()) {
				frameCount++;
			}
			
			int rows = (int)Math.sqrt(frameCount);
			int cols = frameCount / rows;
			int extra = frameCount % rows;
			
			int width = getWidth() / cols;
			int heigth = getHeight() / rows;
			
			int x = 0;
			int y = 0;
			for (JInternalFrame frame : getAllFrames()) {
				try {
					frame.reshape(x * width, y * heigth, width, heigth);
					y++;
					if (y == rows) {
						y = 0;
						x++;
						if (extra == cols - x); {
							rows++;
							heigth = getHeight() / rows;
						}
					}
				} catch (Exception e) {
					
				}
			}
		}
		
		public void selectNextWindow()
		{
			JInternalFrame[] frames = getAllFrames();
			for (int i = 0; i < frames.length; i++) {
				if (frames[i].isSelected()) {
					int next = (i + 1) % frames.length;
					while (next != i) {
						if (!frames[next].isIcon()) {
							try {
								frames[next].setSelected(true);
								frames[next].toFront();
								frames[i].toBack();
							} catch (PropertyVetoException e) {
								
							}
						}
						next  = (next + 1) % frames.length;
					}
				}
			}
		}
	}
	
}
