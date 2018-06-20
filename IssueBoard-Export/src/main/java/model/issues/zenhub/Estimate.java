package model.issues.zenhub;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Estimate {
	private Double value;

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;

	}

	@Override
	public String toString() {
		return value.toString();
	}

}
