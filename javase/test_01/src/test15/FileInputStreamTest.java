package test15;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamTest {
	public static void main(String[] args) throws IOException
	{
		FileInputStream fis = new FileInputStream("mysql.ini");
		
		byte[] bbuf = new byte[1024];
		
		int hadRead = 0;
		while ((hadRead = fis.read(bbuf)) > 0) {
			System.out.println(new String(bbuf, 0 , hadRead));
		}
		
		fis.close();
	}
}
