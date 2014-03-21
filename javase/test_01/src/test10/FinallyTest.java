package test10;

import java.io.FileInputStream;
import java.io.IOException;

public class FinallyTest {
	public static void main(String[] args) {
		FileInputStream fisFileInputStream = null;
		try {
			fisFileInputStream = new FileInputStream("a.rxt");
		} catch (IOException e) {
			System.out.println(e.getMessage());
			return;
		} finally {
			if (fisFileInputStream != null) {
				try {
					fisFileInputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			System.out.println("执行finally块里的资源回收");
		}
	}
}
