package null_result._noif.performer;

import java.util.function.Consumer;

import null_result._noif.interfaces.IPerformer;

public class Performer<T> implements IPerformer<T> {

  private final T value;

  public Performer(final T value) {
    this.value = value;
  }

  @Override
  public void ask(final Consumer<T> action) {
    action.accept(value);
  }
}
