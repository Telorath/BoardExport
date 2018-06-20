package csvFormatter.model;

import java.util.HashMap;

public class MapSet<V, T extends KeyedType<V>> extends HashMap<V, T> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2743545147711186980L;

	public void put(T entry) {
		put(entry.getKey(), entry);
	}
	
	public T get(T EntryExample)
	{
		return get(EntryExample.getKey());
	}
	
	public boolean containsKey(T EntryExample)
	{
		return containsKey(EntryExample.getKey());
	}
	
}
