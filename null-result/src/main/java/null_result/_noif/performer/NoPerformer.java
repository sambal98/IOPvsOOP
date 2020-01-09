package null_result._noif.performer;

import java.util.function.Consumer;

import null_result._noif.interfaces.IPerformer;

public class NoPerformer<T> implements IPerformer<T> {

  @Override
  public void ask(final Consumer<T> action) {}
}
