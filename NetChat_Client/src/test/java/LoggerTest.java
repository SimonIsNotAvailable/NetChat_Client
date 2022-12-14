import Logger.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoggerTest {

    private Logger logger;

    @Test
    public void logTestTrue() {
        String msg = "TEST INITIATED: Hi all";

        logger = Logger.getInstance();

        boolean actual = logger.log(msg, LogType.MESSAGE, false);

        assertTrue(actual);
    }
}
