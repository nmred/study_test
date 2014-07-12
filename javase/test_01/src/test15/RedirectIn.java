package test15;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class RedirectIn {
	public static void main(String[] args)
	{
		try (
			FileInputStream fis = new FileInputStream("mysql.ini"))
		{
			System.setIn(fis);
			Scanner sc = new Scanner(System.in);
			sc.useDelimiter("\n");
			while (sc.hasNext()) {
				System.out.println("键盘输入的内容是：" + sc.next());
			}
			sc.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
