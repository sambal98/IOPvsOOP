package salary.calculator._noif.polymorphism;

import salary.calculator._noif.polymorphism.abztract.EmployeePolymorphism;

public class LeaderPolymorphism extends EmployeePolymorphism {

  public LeaderPolymorphism(final int days) {
    super(days);
  }

  @Override
  public double salary() {
    return getDays() * 60;
  }
}
