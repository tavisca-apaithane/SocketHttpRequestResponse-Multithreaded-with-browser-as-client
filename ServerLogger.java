import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class ServerLogger {
   private static LogManager logManager = LogManager.getLogManager();
   private static Logger logger = logManager.getLogger(Logger.GLOBAL_LOGGER_NAME);


    public static void log(String message)
   {
       try {
           FileHandler fileHandler = new FileHandler("ap.txt");
           fileHandler.setFormatter(new SimpleFormatter());
           logger.addHandler(fileHandler);
           logger.info(message);
       } catch (IOException e) {
           e.printStackTrace();
       }
   }

}
