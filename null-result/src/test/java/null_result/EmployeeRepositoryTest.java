package null_result;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import null_result._if.EmployeeEnum;
import null_result._if.EmployeeRepository;
import null_result._noif.EmployeeEnumPerformer;
import null_result._noif.EmployeeRepositoryPerformer;
import null_result._noif.interfaces.IPerformer;

public class EmployeeRepositoryTest {

  @Test
  public void employeeRepositoryIf() {

    final String expected = "A";

    final EmployeeRepository repo = new EmployeeRepository();

    final EmployeeEnum employee = repo.getOrNull("A");
    if (employee != null) {
      Assertions.assertEquals(expected, employee.name);
    }
  }

  @Test
  public void employeeRepositoryNoIf() {

    final String expected = "A";

    final EmployeeRepositoryPerformer repo = new EmployeeRepositoryPerformer();

    final IPerformer<EmployeeEnumPerformer> performer = repo.getOrNull("A");
    performer.ask(employee -> Assertions.assertEquals(expected, employee.name));
  }
}
