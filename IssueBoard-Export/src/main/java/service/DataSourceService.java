package service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class DataSourceService {
	public static String GITHUB_AUTH_TOKEN;
	public static String ZENHUB_AUTH_TOKEN;

	public static final String gitHubAuthFilePath = "GitAuthToken.txt";
	public static final String zenHubAuthFilePath = "ZenAuthToken.txt";

	public static void loadTokens() throws IOException {

		File gitFile = new File(gitHubAuthFilePath);

		BufferedReader reader = new BufferedReader(new FileReader(gitFile));

		String line;

		while ((line = reader.readLine()) != null) {
			GITHUB_AUTH_TOKEN = line;
		}

		File zenFile = new File(zenHubAuthFilePath);

		reader = new BufferedReader(new FileReader(zenFile));

		while ((line = reader.readLine()) != null) {
			ZENHUB_AUTH_TOKEN = line;
		}

	}

}
