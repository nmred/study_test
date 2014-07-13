package test15;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

public class FileChannelTest {
	public static void main(String[] args)
	{
		File f = new File("src/test15/FileChannelTest.java");
		try (
			FileChannel inChannel  = new FileInputStream(f).getChannel();
			FileChannel outChannel = new FileOutputStream("a.txt").getChannel())
		{
			MappedByteBuffer buffer = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, f.length());
			outChannel.write(buffer);
			
			Charset charset = Charset.forName("GBK");
			buffer.clear();
			CharsetDecoder decoder = charset.newDecoder();
			CharBuffer charBuffer = decoder.decode(buffer);
			System.out.println(charBuffer);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
