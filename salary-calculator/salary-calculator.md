# Salary calculator
In questo esempio abbiamo bisogno di creare programma per il calcolo del salario.

## Prima soluzione (IF):

Creiamo 2 classi EmployeeEnum con le informazioni dell'impiegato e SalaryCalculatorEnum che si occupa del calcolo del salario.

### EmployeeEnum:
```java
public class EmployeeEnum {

  private int days;
  private Cluster cluster;

  public enum Cluster {
    DIRECTOR,
    EXECUTIVE,
    MANAGER,
    LEADER,
    OFFICE_WORKER
  }

  public int getDays() {
    return days;
  }

  public void setDays(final int days) {
    this.days = days;
  }

  public Cluster getCluster() {
    return cluster;
  }

  public void setCluster(final Cluster cluster) {
    this.cluster = cluster;
  }
}
```

### SalaryCalculatorEnum:
```java
public class SalaryCalculatorEnum {

  public double calculate(final EmployeeEnum employee) {

    switch (employee.getCluster()) {
      case DIRECTOR:
        return employee.getDays() * 100;
      case EXECUTIVE:
        return employee.getDays() * 80;
      case LEADER:
        return employee.getDays() * 60;
      case MANAGER:
        return employee.getDays() * 45;
      case OFFICE_WORKER:
        return employee.getDays() * 25;
    }
    return -1;
  }
}
```

## Seconda soluzione (No IF) => Polimorfismo:

Creiamo n classi come DirectorPolymorphism per ogni tipo di impiegato tutte che estendono la stessa classe astratta EmployeePolymorphism con il comportamento standard per tutte le classi impiegato.

In questo modo però spostiamo la logica da un unico posto a tutte le classi che estendono la classe astratta.

### EmployeePolymorphism:
```java
public abstract class EmployeePolymorphism {

  private String name;
  private String last;
  private String number;
  private final int days;

  public EmployeePolymorphism(final int days) {
    this.days = days;
  }

  public abstract double salary();

  public String getName() {
    return name;
  }

  public void setName(final String name) {
    this.name = name;
  }

  public String getLast() {
    return last;
  }

  public void setLast(final String last) {
    this.last = last;
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(final String number) {
    this.number = number;
  }

  public int getDays() {
    return days;
  }
}
```

### DirectorPolymorphism, ... :
```java
public class DirectorPolymorphism extends EmployeePolymorphism {

  public DirectorPolymorphism(final int days) {
    super(days);
  }

  @Override
  public double salary() {
    return getDays() * 100;
  }
}
```

## Terza soluzione (No IF) => Visitors:

Creiamo n classi come DirectorVisitor per ogni tipo di impiegato tutte che estendono la stessa classe astratta EmployeeVisitor con il comportamento standard per tutte le classi impiegato.

In oltre si crea un interfaccia ISalaryCalculationVisitor con i vari tipi di impiegato e la facciamo implementare da un classe fisica che avrà dentro di tutte le logiche di calcolo del salario.

In questo modo abbiamo ricentralizzato la logica, ma se aggiungiamo un novo tipo di impiegato non dobbiamo ricordarci di controllare tutte le classi che implementano logiche su quest'ultimo, ma ci viene in aiuto direttamente il codice sagnalando errori di compilazione.


### IEmployeeVisitor:
```java
public interface IEmployeeVisitor<T> {

  T accept(ISalaryCalculationVisitor<T> visitor);
}
```

### ISalaryCalculationVisitor:
```java
public interface ISalaryCalculationVisitor<T> {

  T visit(DirectorVisitor employee);

  T visit(ExecutiveVisitor employee);

  T visit(LeaderVisitor employee);

  T visit(ManagerVisitor employee);

  T visit(OfficeWorkerVisitor employee);
}
```

### EmployeeVisitor:
```java
public abstract class EmployeeVisitor implements IEmployeeVisitor<Double> {

  private String name;
  private String last;
  private String number;
  private final int days;

  public EmployeeVisitor(final int days) {
    this.days = days;
  }
  //...
}
```

### DirectorVisitor, ... :
```java
public class DirectorVisitor extends EmployeeVisitor {

  public DirectorVisitor(final int days) {
    super(days);
  }

  @Override
  public Double accept(final ISalaryCalculationVisitor<Double> visitor) {
    return visitor.visit(this);
  }
}
```