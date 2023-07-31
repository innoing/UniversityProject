package api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class RestHelper {
	protected String toUtfString(String rawString) throws UnsupportedEncodingException {
		String encodedString = URLEncoder.encode(rawString, "UTF-8");
		
		return encodedString;
	}
	
	protected static String getHTML(String urlToRead) throws Exception {
		String line;
		BufferedReader rd;
		
		StringBuilder result = new StringBuilder();
		URL url = new URL(urlToRead);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				
		conn.setRequestMethod("GET");
		rd = new BufferedReader(new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8));
		while ((line = rd.readLine()) != null) {
			result.append(line);
		}		
		
		rd.close();
		return result.toString();
	}
}
