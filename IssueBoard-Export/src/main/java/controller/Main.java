package controller;

import java.io.IOException;

import service.factories.ServiceFactory;
import service.testing.TestServiceFactory;
import view.MainWindow;

public class Main {

	static ServiceFactory serviceFactory = new TestServiceFactory();

	public static void main(String[] args) throws IOException {
		MainWindow.invokeWindow();
	}

}