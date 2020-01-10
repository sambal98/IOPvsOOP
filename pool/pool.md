# Pool
In questo esempio ci saranno due Classi pool che dato un array, alla chiamata del metodo get restituiranno ogni volta l'elemento successivo in loop.

## FooPool :
```java
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
    if (index == foos.length) { // IF che verrà rimossa
      index = 0;
    }
    return foo;
  }
}
```

## FooPoolMath :
```java
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
```