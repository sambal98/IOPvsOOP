package salary.benefit.calculator._noif;

import salary.benefit.calculator._noif.abztract.EmployeeVisitor;
import salary.benefit.calculator._noif.interfaces.ISalaryCalculationVisitor;

public class LeaderVisitor extends EmployeeVisitor {

  public LeaderVisitor(final int days) {
    super(days);
  }

  @Override
  public Double accept(final ISalaryCalculationVisitor<Double> visitor) {
    return visitor.visit(this);
  }
}
