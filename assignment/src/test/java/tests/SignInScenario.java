package tests;

import base.TestBaseSetup;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.Log;

import java.io.IOException;
import static interfaces.ClassObject.*;

public class SignInScenario extends TestBaseSetup {

    String email, userName, password;

    @BeforeClass

    public void intialzeLoginData() throws IOException, ParseException {

        email = (String) readJson.readJsonData("employee.json").get("email");
        password = (String) readJson.readJsonData("employee.json").get("password");
        userName = (String) readJson.readJsonData("employee.json").get("username");
    }

    @Test
    public void verifySignIn() throws InterruptedException{
        Log.startLog("SignIn");
        signIn.signInUser(email, password);
        Thread.sleep(2000);
        Assert.assertTrue(driver.findElement(By.xpath("//a[normalize-space(text()) = '" + userName + "']")).isDisplayed());
        signIn.signOutUser();
        Log.endLog();

    }



}