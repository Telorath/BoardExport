package view.output;

public interface FileOutputTarget<T> extends BufferedOutputTarget<T> {

	public boolean isOpen();
	public void setFolder(String folder);
	public void setFileName(String filename);
	public void close();
	public void open();
}
