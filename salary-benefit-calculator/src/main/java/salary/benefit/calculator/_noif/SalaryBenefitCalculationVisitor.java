package salary.benefit.calculator._noif;

import salary.benefit.calculator._noif.interfaces.ISalaryCalculationVisitor;

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
