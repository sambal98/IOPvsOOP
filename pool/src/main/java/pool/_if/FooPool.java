package pool._if;

import pool.Foo;

public class FooPool {

  private final Foo[] foos;
  private int index;

  public FooPool(final Foo[] foos) {
    this.foos = foos;
    index = 0;
  }

  public Foo get() {
    final Foo foo = foos[index];
    index++;
    if (index == foos.length) {
      index = 0;
    }
    return foo;
  }
}
