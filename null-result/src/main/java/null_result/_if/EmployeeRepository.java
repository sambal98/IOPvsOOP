package null_result._if;

import java.util.stream.Stream;

public class EmployeeRepository {

  private final EmployeeEnum[] repository = {
    new EmployeeEnum() {
      {
        name = "A";
        cluster = Cluster.DIRECTOR;
        days = 10;
      }
    },
    new EmployeeEnum() {
      {
        name = "B";
        cluster = Cluster.EXECUTIVE;
        days = 20;
      }
    },
    new EmployeeEnum() {
      {
        name = "C";
        cluster = Cluster.OFFICE_WORKER;
        days = 30;
      }
    }
  };

  public EmployeeEnum getOrNull(final String name) {

    return Stream.of(repository)
        .filter(employee -> employee.name.equals(name))
        .findFirst()
        .orElse(null);
  }
}
