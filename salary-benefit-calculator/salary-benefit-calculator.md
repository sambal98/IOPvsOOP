# Salary benefit calculator
In questo esempio vogliamo aggiungere il calcolo di un benefit al calcolo del salario.

## Prima soluzione (IF):

Creiamo una classe SalaryBenefitCalculatorEnum che prende in ingresso SalaryCalculatorEnum ed ah un metodo calculate che prende in ingresso l'impiegato, prima di tutto calcola il salario e poi in base al cluster di appartenenza dell'impiegato calcola il benefit.

### SalaryBenefitCalculatorEnum:
```java
public class SalaryBenefitCalculatorEnum {

  SalaryCalculatorEnum inner;

  public SalaryBenefitCalculatorEnum(final SalaryCalculatorEnum inner) {
    this.inner = inner;
  }

  public double calculate(final EmployeeEnum employee) {

    final double result = inner.calculate(employee);

    switch (employee.getCluster()) {
      case DIRECTOR:
        return benefit(result, 3);
      case EXECUTIVE:
        return benefit(result, 5);
      case LEADER:
        return benefit(result, 5);
      case MANAGER:
        return benefit(result, 10);
      case OFFICE_WORKER:
        return benefit(result, 20);
    }
    return -1;
  }

  private double benefit(final double result, final int ratio) {
    return result + result / 100 * ratio;
  }
}
```

## Seconda soluzione (No IF) :

Creiamo sempre una classe che implementa sempre ISalaryCalculationVisitor con tutti i metodi per il calcolo del benefit a seconda del tipo di impiegato.

### SalaryBenefitCalculationVisitor:
```java
public class SalaryBenefitCalculationVisitor implements ISalaryCalculationVisitor<Double> {

  ISalaryCalculationVisitor<Double> inner;

  public SalaryBenefitCalculationVisitor(final ISalaryCalculationVisitor<Double> inner) {
    this.inner = inner;
  }

  @Override
  public Double visit(final DirectorVisitor employee) {
    return benefit(inner.visit(employee), 3);
  }

  @Override
  public Double visit(final ExecutiveVisitor employee) {
    return benefit(inner.visit(employee), 5);
  }

  @Override
  public Double visit(final LeaderVisitor employee) {
    return benefit(inner.visit(employee), 5);
  }

  @Override
  public Double visit(final ManagerVisitor employee) {
    return benefit(inner.visit(employee), 10);
  }

  @Override
  public Double visit(final OfficeWorkerVisitor employee) {
    return benefit(inner.visit(employee), 20);
  }

  private double benefit(final double result, final int ratio) {
    return result + result / 100 * ratio;
  }
}
```