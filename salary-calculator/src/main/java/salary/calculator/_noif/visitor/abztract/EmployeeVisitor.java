package salary.calculator._noif.visitor.abztract;

import salary.calculator._noif.visitor.interfaces.IEmployeeVisitor;

public abstract class EmployeeVisitor implements IEmployeeVisitor<Double> {

  private String name;
  private String last;
  private String number;
  private final int days;

  public EmployeeVisitor(final int days) {
    this.days = days;
  }

  public String getName() {
    return name;
  }

  public void setName(final String name) {
    this.name = name;
  }

  public String getLast() {
    return last;
  }

  public void setLast(final String last) {
    this.last = last;
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(final String number) {
    this.number = number;
  }

  public int getDays() {
    return days;
  }
}
