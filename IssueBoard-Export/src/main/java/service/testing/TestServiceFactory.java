package service.testing;

import service.DateService;
import service.factories.ObjectFactory;
import service.factories.ServiceFactory;

public class TestServiceFactory extends ServiceFactory {

	@Override
	protected ObjectFactory initializeObjectFactory() {
		ObjectFactory factory = new TestObjectFactory();
		factory.setServiceFactory(this);
		return factory;
	}

	@Override
	protected DateService initializeDateService() {
		return new TestDateService();
	}

}
