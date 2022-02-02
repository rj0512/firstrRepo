package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import utilities.Log;
import utilities.TestUtility;
import java.io.IOException;
import static base.TestBaseSetup.*;
import static interfaces.ClassObject.readJson;

public class BrowserSetting {


    public WebDriver intializeBrowser() throws IOException, ParseException {

        if (browser == null) {
          Log.error("Please add browser as Chrome or Firefox or Safari or Edge");
            System.exit(1);
        }
        switch (browser.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                driver.get(getAppURL());
                //enterValidCredentials();
                return driver;

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
                driver.get(getAppURL());
                return driver;

            case "safari":
                Runtime.getRuntime().exec("safaridriver --enable");
                driver = new SafariDriver();
                driver.manage().window().maximize();
                driver.get(getAppURL());
                return driver;

            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                driver.manage().window().maximize();
                driver.get(getAppURL());
                return driver;

            default:
               Log.error("Please provide valid browser name");
        }
        return null;

    }

    public void closeBrowser() {
        driver.quit();
    }

    public void getURL(String url) {
        driver.get(url);
    }



   public static void enterValidCredentials() throws IOException, ParseException {
       String username = (String) readJson.readJsonData("main.json").get("username");
       String password = (String) readJson.readJsonData("main.json").get("password");
       String url = (String) readJson.readJsonData("main.json").get("url");
       String finalUrl = "https://"+username+":"+password+"@"+url;
        TestUtility.enterCredentialInUrl(finalUrl);
    }



   public static String getAppURL() throws IOException, ParseException {
       String username = (String) readJson.readJsonData("main.json").get("username");
       String password = (String) readJson.readJsonData("main.json").get("password");
       String url = (String) readJson.readJsonData("main.json").get("url");
        return "https://"+username+":"+password+"@"+url;
    }
}
