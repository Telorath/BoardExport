package view.output;

/**
 * A buffered output only performs updates when "Update" is called. Should be
 * used when the underlying output is expensive to write to.
 * 
 * @author kyle.bennett
 *
 */

public interface BufferedOutputTarget extends OutputTarget {

	public void update();

}
