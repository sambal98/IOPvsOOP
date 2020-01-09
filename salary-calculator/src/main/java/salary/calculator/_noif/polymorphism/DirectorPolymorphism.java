package salary.calculator._noif.polymorphism;

import salary.calculator._noif.polymorphism.abztract.EmployeePolymorphism;

public class DirectorPolymorphism extends EmployeePolymorphism {

  public DirectorPolymorphism(final int days) {
    super(days);
  }

  @Override
  public double salary() {
    return getDays() * 100;
  }
}
