package service.testing;

import controller.testing.TestGitController;
import controller.testing.TestZenController;
import interfaces.GitController;
import interfaces.ZenController;
import service.factories.ObjectFactory;

public class TestObjectFactory extends ObjectFactory {
	
	@Override
	public GitController buildGitController()
	{
		TestGitController controller = new TestGitController();

		controller.setRepo(getServiceFactory().getTestRepoService());

		return controller;
		
	}
	
	@Override
	public ZenController buildZenController()
	{
		TestZenController controller = new TestZenController();

		controller.setRepo(getServiceFactory().getTestRepoService());

		return controller;
	}
	
}
