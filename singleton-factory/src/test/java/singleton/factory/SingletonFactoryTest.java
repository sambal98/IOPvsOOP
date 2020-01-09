package singleton.factory;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import singleton.factory._if.FooSingletonLazyFactoryIf;

public class SingletonFactoryTest {

  @Test
  public void fooSingletonLazyFactoryIf() {

    final FooSingletonLazyFactoryIf factory = new FooSingletonLazyFactoryIf();

    final Foo foo1 = factory.get();
    final Foo foo2 = factory.get();

    Assertions.assertEquals(foo1, foo2);
  }
}
