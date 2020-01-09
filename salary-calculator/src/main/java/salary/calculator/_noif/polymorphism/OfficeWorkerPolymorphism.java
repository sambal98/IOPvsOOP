package salary.calculator._noif.polymorphism;

import salary.calculator._noif.polymorphism.abztract.EmployeePolymorphism;

public class OfficeWorkerPolymorphism extends EmployeePolymorphism {

  public OfficeWorkerPolymorphism(final int days) {
    super(days);
  }

  @Override
  public double salary() {
    return getDays() * 25;
  }
}
