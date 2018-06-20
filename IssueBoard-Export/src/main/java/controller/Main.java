package controller;

import java.io.IOException;

import service.ServiceFactory;

public class Main {

	static ServiceFactory serviceFactory = new ServiceFactory();

	public static void main(String[] args) throws IOException {
		serviceFactory.getMainExportController().defaultControlFlow();
	}

}