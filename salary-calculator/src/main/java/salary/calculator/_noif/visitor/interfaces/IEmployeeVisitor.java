package salary.calculator._noif.visitor.interfaces;

public interface IEmployeeVisitor<T> {

  T accept(ISalaryCalculationVisitor<T> visitor);
}
