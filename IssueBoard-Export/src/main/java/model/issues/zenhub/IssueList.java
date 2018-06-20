package model.issues.zenhub;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class IssueList extends ArrayList<Issue> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9068501569344043477L;

}
