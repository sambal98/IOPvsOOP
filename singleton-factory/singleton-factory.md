# Singleton factory
In questo esempio vogliamo creare una classe che deve instanziare solo una volta un oggetto generico Foo e ogni volta che viene richiamato il metodo get ritorni l'oggetto appena creato.

## Prima soluzione (IF):

### FooSingletonLazyFactoryIf:
```java
public class FooSingletonLazyFactoryIf {

  private Foo foo;

  public Foo get() {
    if (foo == null) {
      foo = new Foo();
    }
    return foo;
  }
}
```

## Seconda soluzione (No IF) :

In questo caso l'idea � quella di creare un Supplier<Foo> che la prima volta istanzia un novo oggetto foo e lo ritorni, ma la seconda volta deve ritornare sempre l'oggetto creato in precedenza.

Questa soluzione non ha particolarmente senso in java ... anche se l'obbiettivo di togliere l'IF � stato comunque raggiunto.

La soluzione proposta non � affatto elegante n� facile da capire, non sempre per migliorare il codice c'� bisogno di togliere delle if.

### FooSingletonLazyFactoryNoIf:
```java
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
```