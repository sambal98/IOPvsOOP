# Catch exception
In questo esempio vogliamo creare una classe che dato un generico promocode ritorni delle eccezioni in base allo stato del promocode.

## Prima soluzione (IF):

### PromocodeStatusIf:
```java
public class PromocodeStatusIf {

  public void apply(final String promocode) {
    throw new ExpiredPromocodeException();
  }
}
```

## Seconda soluzione (No IF) :

Creiamo un builder che esegue delle azzioni preassegnate a seconda dell'errore riscontrato.

In questo modo siamo riusciti a togliere tutti try-catch degli utilizzatori di PromocodeStatusIf

### PromocodeStatusNoIf:
```java
public class PromocodeStatusNoIf {

  private Runnable notValidAction;
  private Runnable expiredAction;
  private Runnable alreadyUsedAction;

  public PromocodeStatusNoIf alreadyUsed(final Runnable action) {
    alreadyUsedAction = action;
    return this;
  }

  public PromocodeStatusNoIf expired(final Runnable action) {
    expiredAction = action;
    return this;
  }

  public PromocodeStatusNoIf notValid(final Runnable action) {
    notValidAction = action;
    return this;
  }

  public void apply(final String promocode) {
    expiredAction.run();
  }
}
```