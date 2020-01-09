package salary.benefit.calculator._if;

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
