package _net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


public class ConnectionTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String protocol = "http";
		String host="www.hao123.com";
		String file = "";
		URL url = null;
//		URLConnection urlConn= null;
		HttpURLConnection urlConn= null;
		try {
//			url = new URL(protocol, host, file);
			url = new URL("http://localhost:8080/thinking/connect?jsopn='asd'");
			urlConn = (HttpURLConnection) url.openConnection();
			urlConn.setDoInput(true);
			urlConn.setDoOutput(true);
//			urlConn.setRequestProperty("method", "post");
			urlConn.setRequestProperty("Connection", "keep-alive");
			urlConn.setRequestMethod("GET");
			Map<String, List<String>> requestPropertys = urlConn.getRequestProperties();
			displayInfo(requestPropertys);
			
			PrintWriter out = new PrintWriter(urlConn.getOutputStream());
			out.print("jsonp=123");
//			out.close();
			urlConn.connect();
			
			out.print("123");
			out.flush();
//			out.close();
			
			System.out.println("response headFiles");
			Map<String, List<String>> headFiles = urlConn.getHeaderFields();
			displayInfo(headFiles);
			
			
			String type = urlConn.getContentType();
			String encoding = urlConn.getContentEncoding();
			int length = urlConn.getContentLength();
			System.out.println(type +"-"+length +"-"+encoding);
			
			String respondMsg = urlConn.getResponseMessage();
			System.out.println(respondMsg);
			
			BufferedReader in = new BufferedReader(new InputStreamReader(urlConn.getInputStream(), "UTF-8"));
			while(in.readLine() != null){
				System.out.println(in.readLine());
			}
			in.close();
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void displayInfo(Map<String, List<String>> info){
		Iterator<String> keys = info.keySet().iterator();
		while(keys.hasNext()){
			String key = keys.next();
			List<String> values = info.get(key);
			StringBuilder builder = new StringBuilder();
			builder.append(key)
					.append(": ");
			for(int i = 0; i<values.size(); i++){
				builder.append(values.get(i));
			}
			System.out.println(builder.toString());
		}
		System.out.println("---------------------------------");
	}
}
