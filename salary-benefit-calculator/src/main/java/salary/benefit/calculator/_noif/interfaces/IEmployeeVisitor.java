package salary.benefit.calculator._noif.interfaces;

public interface IEmployeeVisitor<T> {

  T accept(ISalaryCalculationVisitor<T> visitor);
}
