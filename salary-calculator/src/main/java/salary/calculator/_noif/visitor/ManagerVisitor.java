package salary.calculator._noif.visitor;

import salary.calculator._noif.visitor.abztract.EmployeeVisitor;
import salary.calculator._noif.visitor.interfaces.ISalaryCalculationVisitor;

public class ManagerVisitor extends EmployeeVisitor {

  public ManagerVisitor(final int days) {
    super(days);
  }

  @Override
  public Double accept(final ISalaryCalculationVisitor<Double> visitor) {
    return visitor.visit(this);
  }
}
