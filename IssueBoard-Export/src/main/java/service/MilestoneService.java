package service;

import java.io.IOException;

import model.http.HttpRequest;

public interface MilestoneService {
	public HttpRequest getMilestoneRequest() throws IOException;
}
