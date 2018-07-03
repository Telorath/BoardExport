package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.filtering.filters.Filter;
import model.issues.github.filters.CreatedAfterFilter;
import service.ServiceFactory;

public class Main {

	static ServiceFactory serviceFactory = new ServiceFactory();

	public static void main(String[] args) throws IOException {
		List<Filter> filters = new ArrayList<>();

		filters.add(new CreatedAfterFilter(serviceFactory.getDateService().getYesterday()));

		serviceFactory.getMainExportController().defaultControlFlow(filters);
	}

}