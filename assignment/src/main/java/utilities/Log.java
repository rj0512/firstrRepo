package utilities;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Log {

    //Initialize Log4j instance

    private  static final String LOG_FILE = "log4j.properties";
   private static Logger Log  = Logger.getLogger(Log.class);
   // private static org.apache.log4j.Logger Log = org.apache.log4j.Logger.getLogger(Log4jDemo.class);

    public  static void main(String  args[]) throws IOException {

        Properties properties = new Properties();
        properties.load(new FileInputStream(LOG_FILE));
        PropertyConfigurator.configure(properties);


    }

    //We can use it when starting tests
    public static void startLog(String classname){
        Log.info("----------------------------------------------------------------");
        Log.info("           Testcase Execution Started For "+ classname           );
        Log.info("----------------------------------------------------------------");
    }

    //We can use it when ending tests
    public static void endLog(){

        Log.info("----------------------------------------------------------------");
        Log.info("                  TestCase Execution Completed                  ");
        Log.info("----------------------------------------------------------------");
    }

    //Info Level Logs
    public static void info (String message) {
        Log.info(message);
    }

    //Warn Level Logs
    public static void warn (String message) {
        Log.warn(message);
    }

    //Error Level Logs
    public static void error (String message) {
        Log.error(message);
    }

    //Fatal Level Logs
    public static void fatal (String message) {
        Log.fatal(message);
    }

    //Debug Level Logs
    public static void debug (String message) {
        Log.debug(message);
    }
}
