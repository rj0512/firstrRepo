package pageobjects;

import base.TestBaseSetup;
import pojo.UserPojo;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.TestUtility;

/**
 * Created by rjoshi on Jan, 2022
 */
public class SignUp extends TestBaseSetup {
    @FindBy(xpath = "//*[@formcontrolname='username']")
    public WebElement txtUserName;

    @FindBy(xpath = "//*[@formcontrolname='email']")
    public WebElement txtEmail;


    @FindBy(xpath = "//*[@formcontrolname='password']")
    public WebElement txtPassword;

    @FindBy(xpath = "//button[normalize-space(text()) = 'Sign up']")
    public WebElement btnSubmit;

    @FindBy(xpath = "//a[normalize-space(text()) = 'Sign in']")
    public WebElement linkSignIn;

    @FindBy(xpath = "//a[normalize-space(text()) = 'Sign up']")
    public WebElement linkSignUp;

    public void signUpUser(UserPojo user){

        TestUtility.clickOnElement(linkSignUp,"Sign Up Link");
        TestUtility.clearAndEnterText(txtUserName,user.getUsername(),"UserName");
        TestUtility.clearAndEnterText(txtEmail,user.getEmail(),"E-mail");
        TestUtility.clearAndEnterText(txtPassword,user.getPassword(),"Password");
        TestUtility.clickOnElement(btnSubmit,"Submit Button");

    }

    public void signUpUserwithUsedName(UserPojo user) throws InterruptedException {

        TestUtility.clickOnElement(linkSignUp,"Sign Up Link");
        TestUtility.clearAndEnterText(txtUserName,user.getUsername(),"UserName");
        TestUtility.clearAndEnterText(txtEmail,user.getEmail(),"E-mail");
        TestUtility.clearAndEnterText(txtPassword,user.getPassword(),"Password");
        TestUtility.clickOnElement(btnSubmit,"Submit Button");
        Thread.sleep(2000);

    }

    public void signUpUser(String userName, String email,String password){
        TestUtility.clickOnElement(linkSignUp,"Sign Up Link");
        TestUtility.clearAndEnterText(txtUserName,userName,"UserName");
        TestUtility.clearAndEnterText(txtEmail,email,"E-mail");
        TestUtility.clearAndEnterText(txtPassword,password,"Password");
        TestUtility.clickOnElement(btnSubmit,"Submit Button");

    }

    public void signUpUser(){
        TestUtility.clickOnElement(linkSignUp,"Sign Up Link");
        TestUtility.clearAndEnterText(txtUserName,"qqqqq","UserName");
        TestUtility.clearAndEnterText(txtEmail,"qqq@qqq.com","E-mail");
        TestUtility.clearAndEnterText(txtPassword,"qqqqq","Password");
        TestUtility.clickOnElement(btnSubmit,"Submit Button");

    }
}

