package singleton.factory;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import singleton.factory._if.FooSingletonLazyFactoryIf;
import singleton.factory._noif.FooSingletonLazyFactoryNoIf;

public class SingletonFactoryTest {

  @Test
  public void fooSingletonLazyFactoryIf() {

    final FooSingletonLazyFactoryIf factory = new FooSingletonLazyFactoryIf();

    final Foo foo1 = factory.get();
    final Foo foo2 = factory.get();

    Assertions.assertEquals(foo1, foo2);
  }

  @Test
  public void fooSingletonLazyFactoryNoIf() {

    final FooSingletonLazyFactoryNoIf factory = new FooSingletonLazyFactoryNoIf();

    final Foo foo1 = factory.get();
    final Foo foo2 = factory.get();
    final Foo foo3 = factory.get();
    final Foo foo4 = factory.get();

    Assertions.assertAll(
        () -> Assertions.assertEquals(foo1, foo2),
        () -> Assertions.assertEquals(foo1, foo3),
        () -> Assertions.assertEquals(foo1, foo4));
  }
}
