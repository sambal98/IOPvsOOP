package salary.benefit.calculator._noif.interfaces;

import salary.benefit.calculator._noif.DirectorVisitor;
import salary.benefit.calculator._noif.ExecutiveVisitor;
import salary.benefit.calculator._noif.LeaderVisitor;
import salary.benefit.calculator._noif.ManagerVisitor;
import salary.benefit.calculator._noif.OfficeWorkerVisitor;

public interface ISalaryCalculationVisitor<T> {

  T visit(DirectorVisitor employee);

  T visit(ExecutiveVisitor employee);

  T visit(LeaderVisitor employee);

  T visit(ManagerVisitor employee);

  T visit(OfficeWorkerVisitor employee);
}
