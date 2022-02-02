package tests;

import base.TestBaseSetup;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pojo.UserPojo;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Log;
import java.io.IOException;
import java.util.Locale;
import static interfaces.ClassObject.*;

public class SignUpScenario extends TestBaseSetup {

    @BeforeClass
    public  void beforeLog(){
        Log.startLog("SignUp");
    }
    @Test
    public void verifySignUpUser() throws InterruptedException, IOException, ParseException {
        //Log.startLog("verifySignUpUser");
        String userName = (String) readJson.readJsonData("employee.json").get("username") + getAlphaNumericString(5).toLowerCase(Locale.ROOT);
        String email = getAlphaNumericString(5) + (String) readJson.readJsonData("employee.json").get("email");
        String password = (String) readJson.readJsonData("employee.json").get("password");
        UserPojo user = new UserPojo(userName, email, password);
        signUp.signUpUser(user);
        Thread.sleep(1000);

        Assert.assertTrue(driver.findElement(By.xpath("//a[normalize-space(text()) = '" + userName + "']")).isDisplayed());

        signIn.signOutUser();
       // Log.endLog();

    }
    @Test
    public void verifySignUpwithUsedUsername() throws InterruptedException, IOException, ParseException {
        //Log.startLog("verifySignUpwithUsedUsername");
        String userName = (String) readJson.readJsonData("employee.json").get("username");
        String email = getAlphaNumericString(5) + (String) readJson.readJsonData("employee.json").get("email");
        String password = (String) readJson.readJsonData("employee.json").get("password");
        String erromsg = (String) readJson.readJsonData("employee.json").get("usernameerrormsg");
        UserPojo user = new UserPojo(userName, email, password);
        signUp.signUpUserwithUsedName(user);
        Assert.assertEquals(erromsg,driver.findElement(By.xpath("//*[@class='error-messages']")).getText());
       // Log.endLog();


    }
    @AfterClass
    public  void AfterLog(){
        Log.endLog();
    }

}