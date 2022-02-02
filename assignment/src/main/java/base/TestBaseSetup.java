package base;


import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;
import reports.ExtentReport;
import utilities.TestUtility;


import java.io.IOException;


public class TestBaseSetup {

    BrowserSetting browserSetting;
    public static WebDriver driver;
    public static String browser = System.getProperty("browser");


    public TestBaseSetup() {
        PageFactory.initElements(driver, this);

    }

    @BeforeSuite

    public void openBrowser() throws IOException, ParseException {

        browserSetting = new BrowserSetting();
        browserSetting.intializeBrowser();
    }


    @AfterSuite
    public void closeBrowser() {
        browserSetting = new BrowserSetting();
        browserSetting.closeBrowser();
    }

    public static String getAlphaNumericString(int n) {

        // chose a Character random from this String
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";

        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {

            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index
                    = (int) (AlphaNumericString.length()
                    * Math.random());

            // add Character one by one in end of sb
            sb.append(AlphaNumericString
                    .charAt(index));
        }
    return sb.toString();

    }
}

