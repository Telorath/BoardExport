package csvFormatter.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Format implements Iterable<Property> {
	
	List<Property> propertyList = new ArrayList<>();

	public List<Property> getPropertyList()
	{
		return propertyList;
	}

	@Override
	public Iterator<Property> iterator() {
		return propertyList.iterator();
	}

}
