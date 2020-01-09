package salary.calculator._noif.polymorphism.abztract;

public abstract class EmployeePolymorphism {

  private String name;
  private String last;
  private String number;
  private final int days;

  public EmployeePolymorphism(final int days) {
    this.days = days;
  }

  public abstract double salary();

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
