package test17;

import java.net.URLDecoder;
import java.net.URLEncoder;

public class URLDecoderTest {
	public static void main(String[] args) throws Exception
	{
		String keyWord = URLDecoder.decode("%E9%83%9D%E5%BF%A0%E7%A7%80", "UTF-8");
		System.out.println(keyWord);
		
		String urlStr = URLEncoder.encode("疯狂JAVA讲义", "UTF-8");
		System.out.println(urlStr);
	}
}
