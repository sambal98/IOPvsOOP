package null_result._noif.interfaces;

import java.util.function.Consumer;

public interface IPerformer<T> {

  void ask(Consumer<T> action);
}
