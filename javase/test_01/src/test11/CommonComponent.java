package test11;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Choice;
import java.awt.Frame;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;

import javax.swing.Box;

public class CommonComponent {
	Frame f = new Frame("test window");
	Button ok = new Button("ok");
	CheckboxGroup cbg = new CheckboxGroup();
	Checkbox maleCheckbox = new Checkbox("man", cbg, true);
	Checkbox femaleCheckbox = new Checkbox("women", cbg, false);
	Checkbox marriedCheckbox = new Checkbox("is marry? ", false);
	Choice colorChooserChoice = new Choice();
	List colorList = new List(6, true);
	TextArea ta = new TextArea(5, 20);
	TextField name = new TextField(50);
	
	public void init() {
		colorChooserChoice.add("red");
		colorChooserChoice.add("green");
		colorChooserChoice.add("blue");
		colorList.add("red");
		colorList.add("green");
		colorList.add("blue");
		
		Panel bottom = new Panel();
		bottom.add(name);
		bottom.add(ok);
		f.add(bottom, BorderLayout.SOUTH);
		
		Panel checkPanel = new Panel();
		checkPanel.add(colorChooserChoice);
		checkPanel.add(maleCheckbox);
		checkPanel.add(femaleCheckbox);
		checkPanel.add(marriedCheckbox);
		
		Box topLeftBox = Box.createVerticalBox();
		topLeftBox.add(ta);
		topLeftBox.add(checkPanel);
		
		Box topBox = Box.createHorizontalBox();
		topBox.add(topLeftBox);
		topBox.add(colorList);
		f.add(topBox);
		f.pack();
		f.setVisible(true);
	}
	
	public static void main(String[] args) {
		new CommonComponent().init();
	}
}
