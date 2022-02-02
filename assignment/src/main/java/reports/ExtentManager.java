package reports;

import com.aventstack.extentreports.ExtentTest;


/**
 * Created by rjoshi on Jan, 2022
 */
public class ExtentManager {

   private ExtentManager(){}

    private static ThreadLocal<ExtentTest> extTest = new ThreadLocal<>();

   public  static ExtentTest getExtentTest(){
        return extTest.get();
    }
    public static void setExtentTest(ExtentTest test){

       extTest.set(test);
    }

    public static void unLoad() {
        extTest.remove();
    }
}
