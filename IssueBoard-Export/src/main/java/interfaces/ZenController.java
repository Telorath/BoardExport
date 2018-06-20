package interfaces;

import java.io.IOException;
import java.util.List;

import model.ZenhubInfo;
import model.issues.interfaces.ZenIssue;

public interface ZenController {

	List<ZenIssue> getZenIssues() throws IOException;

	ZenhubInfo getZenhubInfo();

	void setZenhubInfo(ZenhubInfo zenhubInfo);

}