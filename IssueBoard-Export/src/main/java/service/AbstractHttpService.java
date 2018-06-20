package service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import model.http.HttpRequest;

public abstract class AbstractHttpService {

	public static final String CONTENT_TYPE = "Content-Type";
	
	public static final String APPLICATION_JSON = "application/json";
	
	public HttpRequest getConnection(String urlString) throws IOException
	{

		URL url = new URL(urlString);
		
		HttpURLConnection connection = (HttpURLConnection)url.openConnection();
		
		connection.setRequestMethod("GET");
		
		connection.setRequestProperty(CONTENT_TYPE, APPLICATION_JSON);

		setConnectionAuthenticationProperty(connection);
		
		HttpRequest output = new HttpRequest();
		
		output.setConnection(connection);
		
		return output;
		
	}
	
	public abstract void setConnectionAuthenticationProperty(HttpURLConnection connection);
	
}
