package model.issues.zenhub;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Board {
	private List<Pipeline> pipelines;

	public List<Pipeline> getPipelines() {
		return pipelines;
	}

	public void setPipelines(List<Pipeline> pipeLines) {
		this.pipelines = pipeLines;
	}
}
