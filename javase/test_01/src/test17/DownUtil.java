package test17;

import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;

public class DownUtil {
	private String path;
	private String targetFile;
	private int threadNum;
	private DownThread[] threads;
	private int fileSize;
	
	public DownUtil(String path, String targetPath, int threadNum)
	{
		this.path = path;
		this.targetFile = targetPath;
		this.threadNum  = threadNum;
		this.threads    = new DownThread[threadNum];
	}
	
	public void download() throws Exception
	{
		URL url = new URL(path);
		HttpURLConnection conn = (HttpURLConnection)url.openConnection();
		conn.setReadTimeout(5 * 1000);
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "image/gif, image/jpeg, image/pjpeg");
		conn.setRequestProperty("Accept-Language", "zh-CN");
		conn.setRequestProperty("Charset", "UTF-8");
		conn.setRequestProperty("Connection", "Keep-Alive");
		
		fileSize = conn.getContentLength();
		conn.disconnect();
		int currentPartSize = fileSize / threadNum + 1;
		RandomAccessFile file = new RandomAccessFile(targetFile, "rw");
		file.setLength(fileSize);
		file.close();
		for (int i = 0; i < threadNum; i++) {
			int startPos = i * currentPartSize;
			RandomAccessFile currentPart = new RandomAccessFile(targetFile, "rw");
			currentPart.seek(startPos);
			threads[i] = new DownThread(startPos, currentPartSize, currentPart);
			threads[i].start();
		}
		
	}
	
	public double getCompleteRate()
	{
		int sumSize = 0;
		for (int i = 0; i < threadNum; i++) {
			sumSize += threads[i].length;
		}
		
		return sumSize * 1.0 / fileSize;
	}
	
	private class DownThread extends Thread
	{
		private int startPos;
		private int currentPartSize;
		private RandomAccessFile currentPart;
		public int length;
		
		public DownThread(int startPos, int currentPartSize, RandomAccessFile currentPart)
		{
			this.startPos = startPos;
			this.currentPart = currentPart;
			this.currentPartSize = currentPartSize;
		}
		
		public void run()
		{
			try {
				URL url = new URL(path);
				HttpURLConnection conn = (HttpURLConnection)url.openConnection();
				conn.setRequestProperty("Accept", "image/gif, image/jpeg, image/pjpeg");
				conn.setRequestMethod("GET");
				conn.setRequestProperty("Accept-Language", "zh-CN");
				conn.setRequestProperty("Charset", "UTF-8");
				InputStream inStream = conn.getInputStream();
				inStream.skip(startPos);
				byte[] buffer = new byte[1024];
				int hasRead = 0;
				while(length < currentPartSize
						&& (hasRead = inStream.read(buffer)) != -1) {
					currentPart.write(buffer, 0, hasRead);
					length += hasRead;
				}
				currentPart.close();
				inStream.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) throws Exception
	{
		final DownUtil downUtil = new DownUtil("http://inapcache.boston.com/universal/site_graphics/blogs/bigpicture/dailylife_072014/bp1.jpg", "aa.jpg", 4);
		downUtil.download();
		new Thread() {
				public void run()
				{
					while(downUtil.getCompleteRate() < 1) {
						System.out.println("已完成：" + downUtil.getCompleteRate());
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
		}.start();
	}
}



