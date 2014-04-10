package test11;

import java.awt.Frame;

public class FrameTest {
	public static void main(String[] args) {
		Frame frame = new Frame("测试窗口");
		frame.setBounds(30, 30, 250, 200);
		frame.setVisible(true);
	}
}
