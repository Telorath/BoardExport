package view.output;

public interface OutputTarget<T> {
	
	void clear();
	
	void write(T output);
	
}
