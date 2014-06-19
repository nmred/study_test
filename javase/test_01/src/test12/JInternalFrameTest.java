package test12;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.MenuBar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;

public class JInternalFrameTest {
	final int DESKTOP_WIDTH = 480;
	final int DESKTOP_HEIGTH = 360;
	final int FRAME_DISTANCE = 30;
	
	JFrame jf = new JFrame("MDI 界面");
	private MyJDesktopPane desktop = new MyJDesktopPane();
	private int nextFrameX;
	private int nextFrameY;
	private int width = DESKTOP_WIDTH / 2;
	private int height = DESKTOP_HEIGTH / 2;
	
	JMenu fileJMenu = new JMenu("文件");
	JMenu windowMenu = new JMenu("窗口");
	Action newAction = new AbstractAction("新建", new ImageIcon("image/new.png")) {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			final JInternalFrame iframe = new JInternalFrame("新文档", true, true, true);
			iframe.add(new JScrollPane(new JTextArea(8, 40)));
			desktop.add(iframe);
			iframe.reshape(nextFrameX, nextFrameY, width, height);
			iframe.show();
			nextFrameX += FRAME_DISTANCE;
			nextFrameY += FRAME_DISTANCE;
			if (nextFrameX + width > desktop.getWidth()) nextFrameX = 0;
			if (nextFrameY + height > desktop.getHeight()) nextFrameY = 0;
			
		}
	};
	
	Action exitAction = new AbstractAction("退出", new ImageIcon("image/exit.png")) {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			System.exit(0);
		}
	};
	
	public void init()
	{
		JMenuBar menuBar = new JMenuBar();
		JToolBar toolBar = new JToolBar();
		jf.setJMenuBar(menuBar);
		menuBar.add(fileJMenu);
		fileJMenu.add(newAction);
		fileJMenu.add(exitAction);
		toolBar.add(newAction);
		toolBar.add(exitAction);
		menuBar.add(windowMenu);
		
		JMenuItem nextItem = new JMenuItem("下一个");
		nextItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				desktop.selectNextWindow();
			}
		});
		windowMenu.add(nextItem);
		JMenuItem cascadeItem = new JMenuItem("级联");
		cascadeItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				desktop.cascadeWindows(FRAME_DISTANCE, 0.75);
			}
		});
		windowMenu.add(cascadeItem);
		JMenuItem titleItem = new JMenuItem("平铺");
		titleItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				desktop.titleWindows();
			}
		});
		windowMenu.add(titleItem);
		final JCheckBoxMenuItem dragOutLineItem = new JCheckBoxMenuItem("仅显示拖动窗口的轮廓");
		dragOutLineItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				desktop.setDragMode(dragOutLineItem.isSelected()
						? JDesktopPane.OUTLINE_DRAG_MODE
						: JDesktopPane.LIVE_DRAG_MODE);
			}
		});
		windowMenu.add(dragOutLineItem);
		desktop.setPreferredSize(new Dimension(480, 360));
		
		jf.add(desktop);
		jf.add(toolBar, BorderLayout.NORTH);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.pack();
		jf.setVisible(true);
	}
	
	public static void main(String[] args)
	{
		new JInternalFrameTest().init();
	}
	
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
