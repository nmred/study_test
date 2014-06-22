package test12;

import java.awt.BorderLayout;
import java.awt.Component;
import java.util.Dictionary;
import java.util.Hashtable;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class JSliderTest {
	JFrame mainWin = new JFrame("滑动条示范");
	Box sliderBox = new Box(BoxLayout.Y_AXIS);
	JTextField showVal = new JTextField();
	ChangeListener listener;

	public void init()
	{
		listener = new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				JSlider source = (JSlider)e.getSource();
				showVal.setText("当前滑动条的值为:" + source.getValue());
			}
		};
		
		JSlider slider = new JSlider();
		addSlider(slider, "普通滑动条");
		
		slider = new JSlider();
		slider.setExtent(30);
		addSlider(slider, "保留区为30");
		
		slider = new JSlider(30, 200);
		slider.setPaintTicks(true);
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(5);
		addSlider(slider, "有刻度");
		
		slider = new JSlider();
		slider.setSnapToTicks(true);
		slider.setPaintTicks(true);
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(5);
		addSlider(slider, "滑块停在刻度处");
		
		slider = new JSlider();
		slider.setPaintTicks(true);
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(5);
		slider.setPaintTrack(false);
		addSlider(slider, "无滑轨");
		
		slider = new JSlider();
		slider.setPaintTicks(true);
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(5);
		slider.setInverted(true);
		addSlider(slider, "方向反转");
		
		slider = new JSlider();
		slider.setPaintTicks(true);
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(5);
		slider.setPaintLabels(true);
		addSlider(slider, "数字刻度标签");
		
		slider = new JSlider();
		slider.setPaintTicks(true);
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(5);
		slider.setPaintLabels(true);
		Dictionary<Integer, Component> labelTable = new Hashtable<>();
		labelTable.put(0, new JLabel("A"));
		labelTable.put(20, new JLabel("B"));
		labelTable.put(40, new JLabel("C"));
		labelTable.put(60, new JLabel("D"));
		labelTable.put(80, new JLabel("E"));
		labelTable.put(100, new JLabel("F"));
		slider.setLabelTable(labelTable);
		addSlider(slider, "Jlabel标签");
		
		slider = new JSlider();
		slider.setPaintTicks(true);
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(5);
		slider.setPaintLabels(true);
		labelTable = new Hashtable<>();
		labelTable.put(0, new JLabel(new ImageIcon("image/1.gif")));
		labelTable.put(20, new JLabel(new ImageIcon("image/2.gif")));
		labelTable.put(40, new JLabel(new ImageIcon("image/3.gif")));
		labelTable.put(60, new JLabel(new ImageIcon("image/4.gif")));
		labelTable.put(80, new JLabel(new ImageIcon("image/1.gif")));
		labelTable.put(100, new JLabel(new ImageIcon("image/2.gif")));
		slider.setLabelTable(labelTable);
		addSlider(slider, "Icon标签");
		
		mainWin.add(sliderBox, BorderLayout.CENTER);
		mainWin.add(showVal, BorderLayout.SOUTH);
		mainWin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWin.pack();
		mainWin.setVisible(true);
	}
	
	public void addSlider(JSlider slider, String description)
	{
		slider.addChangeListener(listener);
		Box box = new Box(BoxLayout.X_AXIS);
		box.add(new JLabel(description + ":"));
		box.add(slider);
		sliderBox.add(box);
	}
	
	public static void main(String[] args)
	{
		new JSliderTest().init();
	}
}
