package pageobjects;

import base.TestBaseSetup;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.TestUtility;


public class SignIn extends TestBaseSetup {
    @FindBy(xpath = "//*[@formcontrolname='username']")
    public WebElement txtUserName;

    @FindBy(xpath = "//*[@formcontrolname='email']")
    public WebElement txtEmail;


    @FindBy(xpath = "//*[@formcontrolname='password']")
    public WebElement txtPassword;

    @FindBy(xpath = "//button[normalize-space(text()) = 'Sign in']")
    public WebElement btnSubmit;

    @FindBy(xpath = "//a[normalize-space(text()) = 'Sign in']")
    public WebElement linkSignIn;

    @FindBy(xpath = "(//*[@class='navbar navbar-light']//a)[last()]")
    public WebElement linkUser;

    @FindBy(xpath = "//*[normalize-space(text()) = 'Edit Profile Settings']")
    public WebElement linkEditProfileSetting;

    @FindBy(xpath = "//*[normalize-space(text()) = 'Or click here to logout.']")
    public WebElement linkLogOut;


    public void signInUser(String email,String password){

        TestUtility.clickOnElement(linkSignIn,"Sign In Link");
        TestUtility.clearAndEnterText(txtEmail,email,"E-mail");
        TestUtility.clearAndEnterText(txtPassword,password,"Password");
        TestUtility.clickOnElement(btnSubmit,"Submit Button");
    }

    public void signOutUser(){
        TestUtility.clickOnElement(linkUser,"User Name");
        TestUtility.clickOnElement(linkEditProfileSetting,"Edit Profile Setting");
        TestUtility.clickOnElement(linkLogOut,"LogOut");

    }


}


