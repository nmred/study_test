package test17;

import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

public class GetPostTest {
	public static String sendGet(String url, String param)
	{
		String result = "";
		String urlName = url + "?" + param;
		try {
			URL realUrl = new URL(urlName);
			URLConnection conn = realUrl.openConnection();
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible;)");
			conn.connect();
			
			Map<String, List<String>> map = conn.getHeaderFields();
			for (String key : map.keySet()) {
				System.out.println(key + "----->" + map.get(key));
			}
			try (
				BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"))
			) {
				String line;
				while ((line = in.readLine()) != null) {
					result += "\n" + line;
				}
			}
		} catch (Exception e) {
			System.out.println("发送GET请求出现异常！" + e);
			e.printStackTrace();
		}
		
		return result;
	}
	
	public static String sendPost(String url, String param)
	{
		String result = "";
		try {
			URL realUrl = new URL(url);
			URLConnection conn = realUrl.openConnection();
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible;)");
			conn.setDoInput(true);
			conn.setDoOutput(true);
			try (
				PrintWriter out = new PrintWriter(conn.getOutputStream())
			) {
				out.print(param);
				out.flush();
			}
			
			try (
				BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"))
			) {
				String line;
				while ((line = in.readLine()) != null) {
					result += "\n" + line;
				}
			}
		} catch (Exception e) {
			System.out.println("发送POST请求出现异常" + e);
			e.printStackTrace();
		}
		
		return result;
	}
	
	public static void main(String[] args)
	{
		String s = GetPostTest.sendGet("http://www.baidu.com", null);
		System.out.print(s);
		
		String post = GetPostTest.sendPost("http://127.0.0.1:10002/test.php", "user=dsdsds&pass=2222");
		System.out.print(post);
	}
}
