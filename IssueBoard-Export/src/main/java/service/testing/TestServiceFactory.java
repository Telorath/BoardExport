package service.testing;

import service.ObjectFactory;
import service.ServiceFactory;

public class TestServiceFactory extends ServiceFactory {

	@Override
	public ObjectFactory initializeObjectFactory() {
		ObjectFactory factory = new TestObjectFactory();
		factory.setServiceFactory(this);
		return factory;
	}
}
