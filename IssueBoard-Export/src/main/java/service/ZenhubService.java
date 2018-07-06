package service;

import java.io.IOException;
import java.net.HttpURLConnection;

import model.ZenhubInfo;
import model.http.HttpRequest;

public class ZenhubService extends AbstractHttpService implements BoardService {

	public static final String ZENHUB_API_URL = "https://api.zenhub.io";

	public static final String REPOSITORY_ACCESS = "/p1/repositories/";

	public static final String REPORTS = "/reports";

	public static final String RELEASES = "/releases";

	public static final String RELEASE = "/release";

	public static final String RELEASES_ACCESS = "/p1/reports/release/";

	public static final String ISSUES = "/issues";

	public static final String BOARD = "/board";

	public static final String AUTHENTICATION_TOKEN = "X-Authentication-Token";

	private ZenhubInfo zenhubInfo;

	public HttpRequest getBoardRequest() throws IOException {
		return getConnection(getBoardURL());
	}

	public HttpRequest getReleasesRequest() throws IOException {
		return getConnection(getReleaseListURL());
	}

	public HttpRequest getReleaseIssues(String releaseId) throws IOException {
		return getConnection(getReleaseIssuesURL(releaseId));
	}

	@Override
	public void setConnectionAuthenticationProperty(HttpURLConnection connection) {
		connection.setRequestProperty(AUTHENTICATION_TOKEN, getAuthToken());
	}

	public String getBoardURL() {
		return ZENHUB_API_URL + REPOSITORY_ACCESS + getBoardId() + BOARD;
	}

	public String getReleaseListURL() {
		return ZENHUB_API_URL + REPOSITORY_ACCESS + getBoardId() + REPORTS + RELEASES;
	}

	public String getReleaseIssuesURL(String releaseId) {
		return ZENHUB_API_URL + RELEASES_ACCESS + releaseId + ISSUES;
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
