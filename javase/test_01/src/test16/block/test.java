package test16.block;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class test {
	public static void main(String[] args)
	{
		BlockingQueue<String> bq = new ArrayBlockingQueue<>(2);
		try {
			bq.put("java");
			bq.put("java");
			bq.put("java");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
