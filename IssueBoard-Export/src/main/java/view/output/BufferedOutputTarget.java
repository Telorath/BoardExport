package view.output;

import java.io.IOException;

/**
 * A buffered output only performs updates when "Update" is called. Should be
 * used when the underlying output is expensive to write to.
 * 
 * @author kyle.bennett
 *
 */

public interface BufferedOutputTarget<T> extends OutputTarget<T> {

	public void update() throws IOException;

}
