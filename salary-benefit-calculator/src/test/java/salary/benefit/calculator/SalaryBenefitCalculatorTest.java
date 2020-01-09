package salary.benefit.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import salary.benefit.calculator._if.EmployeeEnum;
import salary.benefit.calculator._if.EmployeeEnum.Cluster;
import salary.benefit.calculator._if.SalaryBenefitCalculatorEnum;
import salary.benefit.calculator._if.SalaryCalculatorEnum;
import salary.benefit.calculator._noif.DirectorVisitor;
import salary.benefit.calculator._noif.SalaryBenefitCalculationVisitor;
import salary.benefit.calculator._noif.SalaryCalculationVisitor;

public class SalaryBenefitCalculatorTest {

  @Test
  public void salaryBenefitCalculatorIf() {

    final double expected = 1030;

    final SalaryBenefitCalculatorEnum calculator =
        new SalaryBenefitCalculatorEnum(new SalaryCalculatorEnum());

    final EmployeeEnum employee = new EmployeeEnum();
    employee.setCluster(Cluster.DIRECTOR);
    employee.setDays(10);

    final double actual = calculator.calculate(employee);

    Assertions.assertEquals(expected, actual);
  }

  @Test
  public void salaryCalculatorNoIf() {

    final double expected = 1030;

    final DirectorVisitor employee = new DirectorVisitor(10);

    final double actual =
        employee.accept(new SalaryBenefitCalculationVisitor(new SalaryCalculationVisitor()));

    Assertions.assertEquals(expected, actual);
  }
}
