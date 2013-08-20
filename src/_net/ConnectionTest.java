package _net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
		String host="localhost:8080";
		String file = "thinking/ConnectionTest_Servlet";
		URL url = null;
//		URLConnection urlConn= null;
		HttpURLConnection urlConn= null;
		try {
//			url = new URL(protocol, host, file);
			url = new URL("http://localhost:8080/thinking/ConnectionTest_Servlet");
			urlConn = (HttpURLConnection) url.openConnection();
//			urlConn.setDoInput(true);
			urlConn.setDoInput(true);
//			urlConn.setRequestProperty("method", "post");
//			urlConn.setRequestProperty("port", "80");
			urlConn.setRequestMethod("POST");
			Map<String, List<String>> requestPropertys = urlConn.getRequestProperties();
			displayInfo(requestPropertys);
			
			urlConn.connect();
			Map<String, List<String>> headFiles = urlConn.getHeaderFields();
			displayInfo(headFiles);
			
			String type = urlConn.getContentType();
			String encoding = urlConn.getContentEncoding();
			int length = urlConn.getContentLength();
			System.out.println(type +"-"+length +"-"+encoding);
			
			/*System.out.println(urlConn.getHeaderField(0));
			System.out.println(urlConn.getHeaderField(1));
			System.out.println(urlConn.getHeaderField(2));
			System.out.println(urlConn.getHeaderField(3));
			System.out.println(urlConn.getHeaderField(4));
			System.out.println(urlConn.getHeaderField(5));
			System.out.println();*/
			
			BufferedReader in = new BufferedReader(new InputStreamReader(urlConn.getInputStream(), "UTF-8"));
			while(in.readLine() != null){
				System.out.println(in.readLine());
			}
			in.close();
			
			String respondMsg = urlConn.getResponseMessage();
			System.out.println(respondMsg);
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
