# Pool
In questo esempio ci saranno due Classi pool che dato un array, alla chiamata del metodo get restituiranno ogni volta l'elemento successivo in loop.

## Prima soluzione (IF):

### FooPool :
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
    if (index == foos.length) { // IF che verr� rimossa
      index = 0;
    }
    return foo;
  }
}
```

## Seconda soluzione (IF):

In questo caso per togliere l'IF � bastata un po' di aritmetica

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