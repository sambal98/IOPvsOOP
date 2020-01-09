package catch_exception;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import catch_exception._if.PromocodeStatusIf;
import catch_exception._noif.PromocodeStatusNoIf;
import catch_exception.exceptions.AlreadyUsedPromocodeException;
import catch_exception.exceptions.ExpiredPromocodeException;
import catch_exception.exceptions.NotValidPromocodeException;

public class CatchExceptionTest {

  private static final Logger LOGGER = LoggerFactory.getLogger(CatchExceptionTest.class);

  @Test
  public void promocodeStatusIf() {

    final PromocodeStatusIf status = new PromocodeStatusIf();

    try {
      status.apply("sdvds73sdn8sds311");
    } catch (final ExpiredPromocodeException exception) {
      LOGGER.info("Expired");
      return;
    } catch (final AlreadyUsedPromocodeException exception) {
      LOGGER.info("Already Used");
      return;
    } catch (final NotValidPromocodeException exception) {
      LOGGER.info("Not Valid");
      return;
    }

    Assertions.fail("no exception");
  }

  @Test
  public void promocodeStatusNoIf() {

    final PromocodeStatusNoIf status = new PromocodeStatusNoIf();

    status
        .alreadyUsed(() -> LOGGER.info("Already Used"))
        .expired(() -> LOGGER.info("Expired"))
        .notValid(() -> LOGGER.info("Not Valid"))
        .apply("sdvds73sdn8sds311");
  }
}
