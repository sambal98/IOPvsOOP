package salary.benefit.calculator._if;

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
