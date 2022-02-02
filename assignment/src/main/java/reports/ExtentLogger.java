package reports;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Media;
import com.aventstack.extentreports.model.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import static base.TestBaseSetup.driver;
import com.aventstack.extentreports.ExtentTest;


public class ExtentLogger{


    public static String getBase64Image(){
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
    }
    public static void pass(String message){
        ExtentManager.getExtentTest().pass(message);

    }
    public static void fail(String message){
        ExtentManager.getExtentTest().fail(message);

    }
    public static void skip(String message){
        ExtentManager.getExtentTest().skip(message);

    }

  public static void log(Status status, String message, Media media){
        ExtentManager.getExtentTest().log(status,message,media);
    }

    public static void log(Status status, String message){

        ExtentManager.getExtentTest().log(status,message);
    }

}
