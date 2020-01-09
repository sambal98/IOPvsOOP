package salary.calculator._noif.visitor.interfaces;

import salary.calculator._noif.visitor.DirectorVisitor;
import salary.calculator._noif.visitor.ExecutiveVisitor;
import salary.calculator._noif.visitor.LeaderVisitor;
import salary.calculator._noif.visitor.ManagerVisitor;
import salary.calculator._noif.visitor.OfficeWorkerVisitor;

public interface ISalaryCalculationVisitor<T> {

  T visit(DirectorVisitor employee);

  T visit(ExecutiveVisitor employee);

  T visit(LeaderVisitor employee);

  T visit(ManagerVisitor employee);

  T visit(OfficeWorkerVisitor employee);
}
