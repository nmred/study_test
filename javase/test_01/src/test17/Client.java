package test17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {
	public static void main(String[] args) throws IOException
	{
		Socket socket = new Socket("127.0.0.1", 30000);
		BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		String line = in.readLine();
		System.out.println("来自服务器的数据：" + line);
		in.close();
		socket.close();
	}
}
