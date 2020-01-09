package pool._noif;

import pool.Foo;

public class FooPoolMath {

  private final Foo[] foos;
  private int index = -1;

  public FooPoolMath(final Foo[] foos) {
    this.foos = foos;
  }

  public Foo get() {
    index = (index + 1) % foos.length;
    return foos[index];
  }
}
