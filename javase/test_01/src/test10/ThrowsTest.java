package test10;

import java.io.FileInputStream;
import java.io.IOException;

public class ThrowsTest {
	public static void main(String[] args) throws IOException {
		FileInputStream fisFileInputStream = new FileInputStream("a.xx");
	}
}
