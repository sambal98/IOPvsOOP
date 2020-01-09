package null_result._noif;

import java.util.stream.Stream;

import null_result._noif.interfaces.IPerformer;
import null_result._noif.performer.NoPerformer;
import null_result._noif.performer.Performer;

public class EmployeeRepositoryPerformer {

  private final EmployeeEnumPerformer[] repository = {
    new EmployeeEnumPerformer() {
      {
        name = "A";
        cluster = Cluster.DIRECTOR;
        days = 10;
      }
    },
    new EmployeeEnumPerformer() {
      {
        name = "B";
        cluster = Cluster.EXECUTIVE;
        days = 20;
      }
    },
    new EmployeeEnumPerformer() {
      {
        name = "C";
        cluster = Cluster.OFFICE_WORKER;
        days = 30;
      }
    }
  };

  public IPerformer<EmployeeEnumPerformer> getOrNull(final String name) {

    final EmployeeEnumPerformer foundedEmployee =
        Stream.of(repository)
            .filter(employee -> employee.name.equals(name))
            .findFirst()
            .orElse(null);

    if (foundedEmployee == null) {
      return new NoPerformer<>();
    }

    return new Performer<>(foundedEmployee);
  }
}
