package service;

import java.io.IOException;

import model.http.HttpRequest;

public interface BoardService {
	public HttpRequest getBoardRequest() throws IOException;
}
