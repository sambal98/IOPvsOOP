package salary.calculator._noif.polymorphism;

import salary.calculator._noif.polymorphism.abztract.EmployeePolymorphism;

public class ExecutivePolymorphism extends EmployeePolymorphism {

  public ExecutivePolymorphism(final int days) {
    super(days);
  }

  @Override
  public double salary() {
    return getDays() * 80;
  }
}
