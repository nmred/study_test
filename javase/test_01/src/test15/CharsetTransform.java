package test15;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

public class CharsetTransform {
	public static void main(String[] args) throws Exception
	{
		Charset cn = Charset.forName("UTF-8");
		CharsetEncoder cnEncoder = cn.newEncoder();
		CharsetDecoder cnDecoder = cn.newDecoder();
		
		CharBuffer cbuff = CharBuffer.allocate(8);
		cbuff.put('孙');
		cbuff.put('务');
		cbuff.put('空');
		cbuff.flip();
		
		ByteBuffer bbuff = cnEncoder.encode(cbuff);
		for (int i = 0; i < bbuff.limit(); i++) {
			System.out.print(bbuff.get(i) + " ");
		}
		
		System.out.println("\n" + cnDecoder.decode(bbuff));
	}
}
