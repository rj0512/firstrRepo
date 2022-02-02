package utilities;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import reports.ExtentLogger;
import java.time.Duration;
import static base.TestBaseSetup.driver;
import static listners.ListnerClass.getBase64Image;

public class TestUtility {

    /**
     * Enter Text in textfield
     *
     * @param element
     * @param textToEnter
     * @param elementName
     */

    public static void enterText(WebElement element, String textToEnter, String elementName) {
        try {
            Log.info("Entering text : " + textToEnter + " in " + elementName);
            element.sendKeys(textToEnter);
            ExtentLogger.log(Status.PASS, "Entered " + textToEnter + " in " + elementName, MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Image()).build());

        } catch (Exception e2) {
            Log.error("Failed to enter text : " + textToEnter + " in " + elementName);
            ExtentLogger.log(Status.FAIL, e2.getMessage(), MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Image()).build());
        }

    }

    /**
     * Click on element
     *
     * @param element
     * @param elementName
     */

    public static void clickOnElement(WebElement element, String elementName) {
        waitTillElementIsDisplayed(element, Duration.ofSeconds(10));
        try {
            element.click();
            Log.info("Tap on " + elementName);
            ExtentLogger.log(Status.PASS, "Tap on " + elementName);
            //ExtentLogger.pass(elementName + " is clicked");
        } catch (Exception e) {
            try {
                if (driver != null) {
                    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
                    Log.info("Tap on " + elementName);
                    ExtentLogger.log(Status.PASS, "Tap on " + elementName);
                }
            } catch (Exception e2) {
                Log.error(e2.getMessage());
                ExtentLogger.log(Status.FAIL, e2.getMessage(), MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Image()).build());
            }
        }
    }



    public static void enterCredentialInUrl(String url) {
        try {
           driver.get(url);
            Log.info("page is loaded with " + url);
            ExtentLogger.log(Status.PASS, "Tap on ");
        } catch (Exception e) {
            Log.error("page is loaded with " + url);
            ExtentLogger.log(Status.FAIL, "Tap on ");

        }
    }

    /**
     * To validate element is displayed on the screen
     *
     * @param element
     * @param elementName
     */

    public static void elementIsDisplayed(WebElement element, String elementName) {
        waitTillElementIsDisplayed(element, Duration.ofSeconds(20));
        try {
            if (element.isDisplayed()) {
                Log.info(elementName + " is Displayed");
                ExtentLogger.log(Status.PASS, elementName + " is Displayed", MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Image()).build());

            }
        } catch (NoSuchElementException e) {
            Log.error(e.getMessage());
            ExtentLogger.log(Status.FAIL, e.getMessage(), MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Image()).build());
        }
    }


    public static void waitTillElementIsDisplayed(WebElement element, Duration timeout) {
        if (driver != null) {

            //  this(driver, timeout, Duration.ofMillis(500L), Clock.systemDefaultZone(), Sleeper.SYSTEM_SLEEPER);
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            wait.until(ExpectedConditions.visibilityOf(element));
        }
    }



    /**
     * Clear Textfield and enter text
     *
     * @param element
     * @param textToEnter
     * @param elementName
     */
    public static void clearAndEnterText(WebElement element, String textToEnter, String elementName) {
        waitTillElementIsDisplayed(element, Duration.ofSeconds(10));
        try {
            Log.info("Clearing text from " + elementName);
            element.clear();
            Log.info("Entering text : " + textToEnter + " in " + elementName);
            element.sendKeys(textToEnter);
            ExtentLogger.log(Status.PASS, "Entered " + textToEnter + " in " + elementName, MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Image()).build());

        } catch (Exception e2) {
            Log.error("Failed to enter text : " + textToEnter + " in " + elementName);
            ExtentLogger.log(Status.FAIL, e2.getMessage(), MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Image()).build());
        }
    }




    /**
     * Clear Textfield
     *
     * @param element
     * @param elementName
     */
    public static void clearText(WebElement element, String elementName) {
        try {
            Log.info(" Clearing text from " + elementName);
            element.clear();
            ExtentLogger.log(Status.PASS, "Cleared text from " + elementName, MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Image()).build());
        } catch (Exception e2) {
            Log.error(" Failed to clear text : " + " in " + elementName);
            ExtentLogger.log(Status.FAIL, e2.getMessage(), MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Image()).build());
        }
    }



}
