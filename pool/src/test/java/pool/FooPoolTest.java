package pool;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import pool._if.FooPool;
import pool._noif.FooPoolMath;

public class FooPoolTest {

  @Test
  public void testFooPool() {
    final Foo expectedFoo_0 = new Foo();
    final Foo expectedFoo_1 = new Foo();
    final Foo expectedFoo_2 = new Foo();
    final FooPool fooPool = //
        new FooPool(new Foo[] {expectedFoo_0, expectedFoo_1, expectedFoo_2});

    Assertions.assertEquals(expectedFoo_0, fooPool.get());
    Assertions.assertEquals(expectedFoo_1, fooPool.get());
    Assertions.assertEquals(expectedFoo_2, fooPool.get());
  }

  @Test
  public void testFooPoolMath() {
    final Foo expectedFoo_0 = new Foo();
    final Foo expectedFoo_1 = new Foo();
    final Foo expectedFoo_2 = new Foo();
    final FooPoolMath fooPoolMath =
        new FooPoolMath(new Foo[] {expectedFoo_0, expectedFoo_1, expectedFoo_2});

    Assertions.assertEquals(expectedFoo_0, fooPoolMath.get());
    Assertions.assertEquals(expectedFoo_1, fooPoolMath.get());
    Assertions.assertEquals(expectedFoo_2, fooPoolMath.get());
  }
}
