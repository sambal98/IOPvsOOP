package salary.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import salary.calculator._if.EmployeeEnum;
import salary.calculator._if.EmployeeEnum.Cluster;
import salary.calculator._if.SalaryCalculatorEnum;
import salary.calculator._noif.polymorphism.DirectorPolymorphism;
import salary.calculator._noif.visitor.DirectorVisitor;
import salary.calculator._noif.visitor.SalaryCalculationVisitor;

public class SalaryCalculatorTest {

  @Test
  public void salaryCalculatorIf() {

    final double expected = 1000;

    final SalaryCalculatorEnum calculator = new SalaryCalculatorEnum();

    final EmployeeEnum employee = new EmployeeEnum();
    employee.setDays(10);
    employee.setCluster(Cluster.DIRECTOR);

    final double actual = calculator.calculate(employee);

    Assertions.assertEquals(expected, actual);
  }

  @Test
  public void salaryCalculatorNoIf1() {

    final double expected = 1000;

    final DirectorPolymorphism employee = new DirectorPolymorphism(10);
    final double actual = employee.salary();

    Assertions.assertEquals(expected, actual);
  }

  @Test
  public void salaryCalculatorNoIf2() {

    final double expected = 1000;

    final DirectorVisitor employee = new DirectorVisitor(10);
    final double actual = employee.accept(new SalaryCalculationVisitor());

    Assertions.assertEquals(expected, actual);
  }
}
