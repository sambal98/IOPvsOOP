package singleton.factory._if;

import singleton.factory.Foo;

public class FooSingletonLazyFactoryIf {

  private Foo foo;

  public Foo get() {
    if (foo == null) {
      foo = new Foo();
    }
    return foo;
  }
}
