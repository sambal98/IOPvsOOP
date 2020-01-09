package salary.calculator._noif.polymorphism;

import salary.calculator._noif.polymorphism.abztract.EmployeePolymorphism;

public class ManagerPolymorphism extends EmployeePolymorphism {

  public ManagerPolymorphism(final int days) {
    super(days);
  }

  @Override
  public double salary() {
    return getDays() * 45;
  }
}
