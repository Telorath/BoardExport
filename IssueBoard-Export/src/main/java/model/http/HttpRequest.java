package model.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

public class HttpRequest {

	private HttpURLConnection connection;

	public HttpURLConnection getConnection() {
		return connection;
	}

	public void setConnection(HttpURLConnection connection) {
		this.connection = connection;
	}

	public String getResponseString() throws IOException {

		InputStream stream = getConnection().getInputStream();

		BufferedReader reader = new BufferedReader(new InputStreamReader(stream));

		String responseLine;

		StringBuffer buffer = new StringBuffer();

		while ((responseLine = reader.readLine()) != null) {
			buffer.append(responseLine);
		}

		return buffer.toString();
	}

}
