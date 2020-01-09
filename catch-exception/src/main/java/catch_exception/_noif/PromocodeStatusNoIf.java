package catch_exception._noif;

public class PromocodeStatusNoIf {

  private Runnable notValidAction;
  private Runnable expiredAction;
  private Runnable alreadyUsedAction;

  public PromocodeStatusNoIf alreadyUsed(final Runnable action) {
    alreadyUsedAction = action;
    return this;
  }

  public PromocodeStatusNoIf expired(final Runnable action) {
    expiredAction = action;
    return this;
  }

  public PromocodeStatusNoIf notValid(final Runnable action) {
    notValidAction = action;
    return this;
  }

  public void apply(final String promocode) {
    expiredAction.run();
  }
}
