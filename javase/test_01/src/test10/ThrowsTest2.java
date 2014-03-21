package test10;

import java.io.FileInputStream;
import java.io.IOException;

public class ThrowsTest2 {
	public static void main(String[] args) throws Exception {
		test();
	}
	
	public static void test() throws IOException {
		FileInputStream fis = new FileInputStream("ass,ss");
	}
}
