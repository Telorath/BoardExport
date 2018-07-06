package view.io;

import view.input.ListInputSource;
import view.output.ListOutputTarget;

public interface IOListTarget<T> extends ListInputSource<T>, ListOutputTarget<T> {

}
