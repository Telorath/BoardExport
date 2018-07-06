package view.input;

import java.util.List;

public interface ListInputSource<T> extends InputSource<T> {

	/**
	 * @return Inputs selected by the user
	 */
	List<T> getInputList();
	/**
	 * All input the user has made available, even if they have not selected it
	 * @return
	 */
	List<T> getAll();
	
}
