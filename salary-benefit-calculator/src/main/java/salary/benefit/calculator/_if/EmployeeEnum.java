package salary.benefit.calculator._if;

public class EmployeeEnum {

  private int days;
  private Cluster cluster;

  public enum Cluster {
    DIRECTOR,
    EXECUTIVE,
    MANAGER,
    LEADER,
    OFFICE_WORKER
  }

  public int getDays() {
    return days;
  }

  public void setDays(final int days) {
    this.days = days;
  }

  public Cluster getCluster() {
    return cluster;
  }

  public void setCluster(final Cluster cluster) {
    this.cluster = cluster;
  }
}
