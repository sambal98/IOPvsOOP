package catch_exception._if;

import catch_exception.exceptions.ExpiredPromocodeException;

public class PromocodeStatusIf {

  public void apply(final String promocode) {
    throw new ExpiredPromocodeException();
  }
}
