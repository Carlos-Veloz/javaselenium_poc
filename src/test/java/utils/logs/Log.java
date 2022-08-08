package utils.logs;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Define logger and messages
 *
 * @lastmodifier Cecilia Ocampo
 */
public class Log {
    private static final Logger Log = LogManager.getLogger(Log.class);

    public static void info(String message) {
        Log.info(message);
    }

    public static void warn(String message) {
        Log.warn(message);
    }

    public static void debug(String message) {
        Log.debug(message);
    }

    public static void error(String message) {
        Log.error(message);
    }

}
