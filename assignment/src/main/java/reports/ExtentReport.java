package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public final class ExtentReport {
    private  ExtentReport(){}
    private static ExtentReports extent;


  static String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
    public static void initReports() throws IOException {
        if(Objects.isNull(extent)) {

            ExtentSparkReporter spark = new ExtentSparkReporter( System.getProperty("user.dir") + "/reports/TestResults_" + timeStamp + ".html");
            extent = new ExtentReports();
            extent.attachReporter(spark);
            final File CONF = new File("extent-config.xml");
            spark.loadXMLConfig(CONF);

        }
    }

    public static void flushReport() throws IOException {
        if(Objects.nonNull(extent)) {
            extent.flush();
            Desktop.getDesktop().browse(new File(System.getProperty("user.dir") + "/reports/TestResults_" + timeStamp + ".html").toURI());
        }
    }

    public static void CreateTest(String testcasename) {

       ExtentTest test = extent.createTest(testcasename);
       ExtentManager.setExtentTest(test);
    }


}

