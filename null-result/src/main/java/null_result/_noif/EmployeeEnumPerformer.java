package null_result._noif;

public class EmployeeEnumPerformer {

  public String name;
  public String last;
  public String number;
  public int days;
  public Cluster cluster;

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
