package tests;

import base.TestBaseSetup;
import org.testng.Assert;
import org.testng.annotations.Test;

import static interfaces.ClassObject.*;


public class LoginWebScenario extends TestBaseSetup {
    @Test
    public void verifyLogin() throws Exception {

        String username = (String) readJson.readJsonData("employee.json").get("username");
        String email = (String) readJson.readJsonData("employee.json").get("email");
        String password = (String) readJson.readJsonData("employee.json").get("password");
        loginpage.verifyLogin(email, password);
        Assert.assertEquals(loginpage.veryfyUserName(), username);
        loginpage.verifyLogout();


    }

}
