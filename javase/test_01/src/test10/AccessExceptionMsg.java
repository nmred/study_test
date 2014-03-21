package test10;

import java.io.FileInputStream;
import java.io.IOException;

public class AccessExceptionMsg {
	public static void main(String[] args) {
		try {
			FileInputStream fisFileInputStream = new FileInputStream("a.txt");
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
