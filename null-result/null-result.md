# Null result
In questo esempio vogliamo creare una classe che dato un array in input abbia un metodo get che dato un nome restituisca il primo impiegato con quel nome oppure null.

## Prima soluzione (IF):

### EmployeeRepository:
```java
public class EmployeeRepository {

  private final EmployeeEnum[] repository = {
    new EmployeeEnum() {
      {
        name = "A";
        cluster = Cluster.DIRECTOR;
        days = 10;
      }
    },
    new EmployeeEnum() {
      {
        name = "B";
        cluster = Cluster.EXECUTIVE;
        days = 20;
      }
    },
    new EmployeeEnum() {
      {
        name = "C";
        cluster = Cluster.OFFICE_WORKER;
        days = 30;
      }
    }
  };

  public EmployeeEnum getOrNull(final String name) {

    return Stream.of(repository)
        .filter(employee -> employee.name.equals(name))
        .findFirst()
        .orElse(null);
  }
}
```

## Seconda soluzione (No IF) :

Creiamo un interfaccia IPerformer che accetta un'azione in un metodo, e due classi che la implementano: NoPerformer che non esegue l'azzione e Performer che invece la esegue.

Così ritornerema Performer o NoPerformer a seconda se il risultato è stato trovato oppure no.

In questo modo siamo riusciti a togliere tutte le if negli utilizzatori di EmployeeRepository

### IPerformer:
```java
public interface IPerformer<T> {

  void ask(Consumer<T> action);
}
```
### NoPerformer:
```java
public class NoPerformer<T> implements IPerformer<T> {

  @Override
  public void ask(final Consumer<T> action) {}
}
```
### Performer:
```java
public class Performer<T> implements IPerformer<T> {

  private final T value;

  public Performer(final T value) {
    this.value = value;
  }

  @Override
  public void ask(final Consumer<T> action) {
    action.accept(value);
  }
}
```
### Performer:
```java
public class EmployeeRepositoryPerformer {

  private final EmployeeEnumPerformer[] repository = {
    new EmployeeEnumPerformer() {
      {
        name = "A";
        cluster = Cluster.DIRECTOR;
        days = 10;
      }
    },
    new EmployeeEnumPerformer() {
      {
        name = "B";
        cluster = Cluster.EXECUTIVE;
        days = 20;
      }
    },
    new EmployeeEnumPerformer() {
      {
        name = "C";
        cluster = Cluster.OFFICE_WORKER;
        days = 30;
      }
    }
  };

  public IPerformer<EmployeeEnumPerformer> getOrNull(final String name) {

    final EmployeeEnumPerformer foundedEmployee =
        Stream.of(repository)
            .filter(employee -> employee.name.equals(name))
            .findFirst()
            .orElse(null);

    if (foundedEmployee == null) {
      return new NoPerformer<>();
    }

    return new Performer<>(foundedEmployee);
  }
}
```