package service;

import csvFormatter.model.Format;
import csvFormatter.model.Property;

public class FormatService {

	public Format getFormat() {
		Format format = new Format();

		format.getPropertyList().add(new Property("number"));
		format.getPropertyList().add(new Property("title"));
		format.getPropertyList().add(new Property("pipeline"));
		format.getPropertyList().add(new Property("state"));
		format.getPropertyList().add(new Property("body", "no body"));
		format.getPropertyList().add(new Property("user"));
		format.getPropertyList().add(new Property("assignees"));
		format.getPropertyList().add(new Property("labels"));
		format.getPropertyList().add(new Property("severity"));
		format.getPropertyList().add(new Property("priority"));
		format.getPropertyList().add(new Property("milestone"));
		format.getPropertyList().add(new Property("estimate", "no estimate"));
		format.getPropertyList().add(new Property("issueType"));
		format.getPropertyList().add(new Property("url"));
		format.getPropertyList().add(new Property("created_at"));
		format.getPropertyList().add(new Property("updated_at"));
		return format;
	}

}
