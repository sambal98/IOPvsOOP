package singleton.factory._noif;

import java.lang.reflect.Field;
import java.util.function.Supplier;

import singleton.factory.Foo;

public class FooSingletonLazyFactoryNoIf {

  private final Supplier<Foo> get;

  public FooSingletonLazyFactoryNoIf() {

    get =
        () -> {
          try {
            final Foo foo = new Foo();
            final Field field = this.getClass().getDeclaredField("get");
            field.setAccessible(true);
            field.set(this, (Supplier<Foo>) () -> foo);
            return foo;
          } catch (IllegalArgumentException
              | IllegalAccessException
              | NoSuchFieldException
              | SecurityException e) {
            e.printStackTrace();
          }
          return null;
        };
  }

  public Foo get() {
    return get.get();
  }
}
