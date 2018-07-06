package interfaces;

import java.io.IOException;
import java.util.List;

import model.ZenhubInfo;
import model.issues.interfaces.ZenIssue;
import model.issues.zenhub.Release;

public interface ZenController {

	List<ZenIssue> getZenIssues() throws IOException;

	List<Release> getZenReleases() throws IOException;
	
	ZenhubInfo getZenhubInfo();

	void setZenhubInfo(ZenhubInfo zenhubInfo);

}