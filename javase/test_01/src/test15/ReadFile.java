package test15;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;


public class ReadFile {
	public static void main(String[] args) throws IOException
	{
		try (
			FileInputStream fis = new FileInputStream("src/test15/ReadFile.java");
			FileChannel fcin = fis.getChannel())
		{
			ByteBuffer bbuff = ByteBuffer.allocate(64);
			while(fcin.read(bbuff) != -1) {
				bbuff.flip();
				Charset charset = Charset.forName("UTF-8");
				CharsetDecoder decoder = charset.newDecoder();
				CharBuffer cbuff = decoder.decode(bbuff);
				System.out.print(cbuff);
				bbuff.clear();
			}
		}
	}
}