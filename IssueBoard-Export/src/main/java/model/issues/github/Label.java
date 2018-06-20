package model.issues.github;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Label {
	Integer id;
	String name;
	String description;
	String color;
	Boolean is_default;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Boolean getIs_default() {
		return is_default;
	}

	public void setIs_default(Boolean is_default) {
		this.is_default = is_default;
	}

	public Boolean getDefault() {
		return is_default;
	}

	public void setDefault(Boolean is_default) {
		this.is_default = is_default;
	}

}
