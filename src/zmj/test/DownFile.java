package zmj.test;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class DownFile {
	final int BUFFER_SIZE = 1024;

	public void saveToFile(String downUrl, String filePath) {
		HttpURLConnection connect = null;
		BufferedInputStream in = null;
		FileOutputStream file = null;
		byte[] buf = new byte[BUFFER_SIZE];
		int size = 0;

		try {
			URL url = new URL(downUrl);
			connect = (HttpURLConnection) url.openConnection();
			connect.connect();
			in = new BufferedInputStream(connect.getInputStream());
			file = new FileOutputStream(filePath);
			while ((size = in.read(buf)) != -1) {
				file.write(buf, 0, size);
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				file.close();
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			connect.disconnect();
		}
	}

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		long start = System.nanoTime(); // 获取开始时间
		DownFile d = new DownFile();
		d.saveToFile("http://eutils.ncbi.nlm.nih.gov/entrez/eutils/esummary.fcgi?db=pubmed&id=11850928&retmode=xml", "D:\\abc.xml");
		System.out.println("down!");
		long endTime = System.currentTimeMillis();
		System.out.println("Time:" + (endTime - startTime)+ "ms");
		long end = System.nanoTime(); // 获取结束时间
		System.out.println("程序运行时间： " + (end - start) + "ns");
	}
}