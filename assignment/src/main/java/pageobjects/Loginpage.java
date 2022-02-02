package pageobjects;

import reports.ExtentLogger;
import base.TestBaseSetup;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.TestUtility;
import org.testng.Assert;


public class Loginpage extends TestBaseSetup {

   @FindBy(xpath = "//*[@class='header_user_info']//a")
     WebElement linkSignIn;

    @FindBy(id = "email")
    public WebElement txtUserName;

    @FindBy(id = "passwd")
    public WebElement txtPassWord;

    @FindBy(id = "SubmitLogin")
    public WebElement btnLogin;

    @FindBy(xpath = "//*[@class='header_user_info']/a/span")
    public WebElement loggedUserName;


    @FindBy(xpath = "//*[@class='logout']")
    public WebElement linkLogout;

    @FindBy(xpath = "//*[@class='logout' and normalize-space(text())='Sign in']")
    public WebElement loginText;


    public void verifyLogin(String emailadress, String password) throws Exception {

        TestUtility.clickOnElement(linkSignIn,"SignIn Link");
        TestUtility.enterText(txtUserName,emailadress,"Emaill Address");
        TestUtility.enterText(txtPassWord,password,"Password Textbox");
        TestUtility.clickOnElement(btnLogin,"Login Button");


    }
    public  void  verifyLogout()
    {
        TestUtility.clickOnElement(linkLogout,"Logout Link");
        Assert.assertTrue(linkSignIn.isDisplayed());

    }
    public String veryfyUserName() {
        return loggedUserName.getText();
    }
}
