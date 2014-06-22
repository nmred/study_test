package test12;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListCellRenderer;

public class ListRenderingTest {
	private JFrame mainWin = new JFrame("好友列表");
	private String[] friends = new String[]
	{
		"1",
		"2",
		"3",
		"4",
		"1"
	};
	
	private JList friendsList = new JList<>(friends);
	
	public void init()
	{
		friendsList.setCellRenderer(new ImageCellRenderer());
		mainWin.add(new JScrollPane(friendsList));
		mainWin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWin.pack();
		mainWin.setVisible(true);
	}
	
	public static void main(String[] args)
	{
		new ListRenderingTest().init();
	}
	
	class ImageCellRenderer extends JPanel implements ListCellRenderer
	{
		private ImageIcon icon;
		private String name;
		private Color backgroundColor;
		private Color foregroundColor;
		public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus)
		{
			icon = new ImageIcon("image/" + value + ".gif");
			name = value.toString();
			backgroundColor = isSelected ? list.getSelectionBackground() : list.getBackground();
			foregroundColor = isSelected ? list.getSelectionForeground() : list.getForeground();
			return this;
		}
		
		public void paintComponent(Graphics g)
		{
			int imageWidth = icon.getImage().getWidth(null);
			int imageHeight = icon.getImage().getHeight(null);
			g.setColor(backgroundColor);
			g.fillRect(0, 0, getWidth(), getHeight());
			g.setColor(foregroundColor);
			g.drawImage(icon.getImage(), getWidth() / 2 - imageWidth / 2, 10, null);
			g.setFont(new Font("SansSerif", Font.BOLD, 18));
			g.drawString(name, getWidth() / 2 - name.length() * 10, imageHeight + 30);
		}
		
		public Dimension getPreferredSize()
		{
			return new Dimension(60, 80);
		}
	}
}
