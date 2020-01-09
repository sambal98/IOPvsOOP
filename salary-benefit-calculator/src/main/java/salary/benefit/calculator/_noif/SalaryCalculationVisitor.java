package salary.benefit.calculator._noif;

import salary.benefit.calculator._noif.interfaces.ISalaryCalculationVisitor;

public class SalaryCalculationVisitor implements ISalaryCalculationVisitor<Double> {

  @Override
  public Double visit(final DirectorVisitor employee) {
    return (double) (employee.getDays() * 100);
  }

  @Override
  public Double visit(final ExecutiveVisitor employee) {
    return (double) (employee.getDays() * 80);
  }

  @Override
  public Double visit(final LeaderVisitor employee) {
    return (double) (employee.getDays() * 60);
  }

  @Override
  public Double visit(final ManagerVisitor employee) {
    return (double) (employee.getDays() * 45);
  }

  @Override
  public Double visit(final OfficeWorkerVisitor employee) {
    return (double) (employee.getDays() * 25);
  }
}
