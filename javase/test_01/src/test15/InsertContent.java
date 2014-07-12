package test15;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

public class InsertContent {
	public static void main(String[] args) throws IOException
	{
		insert("out.txt", 10, "插入的内容\r\n");
	}
	
	public static void insert(String fileName, long pos, String insertContent) throws IOException
	{
		File tmp = File.createTempFile("tmp", null);
		tmp.deleteOnExit();
		try (
			RandomAccessFile raf = new RandomAccessFile(fileName, "rw");
			FileInputStream tmpIn = new FileInputStream(tmp);
			FileOutputStream tmpOut = new FileOutputStream(tmp))
		{
			raf.seek(pos);
			
			byte[] bbuf = new byte[64];
			int hadRead = 0;
			while ((hadRead = raf.read(bbuf)) > 0) {
				tmpOut.write(bbuf, 0, hadRead);
			}
			
			raf.seek(pos);
			raf.write(insertContent.getBytes());
			
			while ((hadRead = tmpIn.read(bbuf)) > 0) {
				raf.write(bbuf, 0, hadRead);
			}
		}
	}
}
