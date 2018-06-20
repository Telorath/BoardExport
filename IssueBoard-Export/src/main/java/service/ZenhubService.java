package service;

import java.io.IOException;
import java.net.HttpURLConnection;

import model.ZenhubInfo;
import model.http.HttpRequest;

public class ZenhubService extends AbstractHttpService implements BoardService {

	public static final String ZENHUB_API_URL = "https://api.zenhub.io";

	public static final String REPOSITORY_ACCESS = "/p1/repositories/";
	
	public static final String BOARD = "/board";
	
	public static final String AUTHENTICATION_TOKEN = "X-Authentication-Token";
	
	private ZenhubInfo zenhubInfo;

	public HttpRequest getBoardRequest() throws IOException
	{
		return getConnection(getBoardURL());
	}
	
	@Override
	public void setConnectionAuthenticationProperty(HttpURLConnection connection) {
		connection.setRequestProperty(AUTHENTICATION_TOKEN, getAuthToken());		
	}

	public String getBoardURL() {
		return ZENHUB_API_URL + REPOSITORY_ACCESS + getBoardId() + BOARD;		
	}
	
	public ZenhubInfo getZenhubInfo() {
		return zenhubInfo;
	}
	
	public void setZenhubInfo(ZenhubInfo zenhubInfo) {
		this.zenhubInfo = zenhubInfo;
	}

	private String getAuthToken() {
		return zenhubInfo.getZenhubToken();
	}

	private String getBoardId() {
		return zenhubInfo.getBoardId();
	}
}
