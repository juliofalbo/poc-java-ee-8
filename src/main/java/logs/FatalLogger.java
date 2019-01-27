package logs;

import java.util.logging.Level;
import java.util.logging.Logger;

//Or you can use Log4J or SLF4J
public class FatalLogger {

    private static final Logger LOGGER = Logger.getLogger(FatalLogger.class.getName());

    public void fatal(Throwable e) {
        LOGGER.log(Level.SEVERE, e.getMessage(), e);
    }
}
