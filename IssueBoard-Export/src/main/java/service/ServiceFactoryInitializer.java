package service;

import service.factories.ServiceFactory;
import service.testing.TestServiceFactory;

/**
 * Provides a single point of entry to the creation of a service factory to be
 * used throughout the program. Later can be data driven to make testing possible without modifying this file.
 * 
 * @author kyle.bennett
 *
 */

public class ServiceFactoryInitializer {

	private ServiceFactory serviceFactory = null;

	public ServiceFactory getServiceFactory() {
		if (serviceFactory == null) {
			serviceFactory = new TestServiceFactory();
		}
		return serviceFactory;
	}

}
