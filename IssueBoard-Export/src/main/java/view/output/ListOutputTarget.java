package view.output;

public interface ListOutputTarget<T> extends OutputTarget<T> {

	public void remove(T item);
	
}
