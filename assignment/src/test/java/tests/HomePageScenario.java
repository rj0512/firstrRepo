package tests;

import reports.ExtentReport;
import base.TestBaseSetup;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ReadJson;

import java.io.IOException;
import static interfaces.ClassObject.*;


public class HomePageScenario extends TestBaseSetup {

    @Test(description = "Verify page title")
    public void verifyPageTitleonHomePage() throws IOException, ParseException {
        ExtentReport.CreateTest("Verify page title");
        String title = (String) readJson.readJsonData("article.json").get("pagetile");
        Assert.assertTrue(homePage.verifyPagetitle(title));
        Assert.assertTrue(homePage.verifyLogo());
    }


    @Test(description = "Verify Links in header")
    public void verifyLinksinHeader() throws Exception {
        ExtentReport.CreateTest("Verify Links in header");
        String mobno = (String) readJson.readJsonData("article.json").get("mobileno");
        Assert.assertTrue(homePage.callUs(mobno));
        String email = (String) readJson.readJsonData("employee.json").get("email");
        String password = (String) readJson.readJsonData("employee.json").get("password");
        loginpage.verifyLogin(email, password);
        Assert.assertTrue(homePage.verifyLogoutText());
        loginpage.verifyLogout();
    }

    @Test(description = "Verify placeholderText")
    public void verifyPlaceholderinSearchbox() throws IOException, ParseException {
        ExtentReport.CreateTest("Verify placeholderText");
        String placeholderText = (String) readJson.readJsonData("article.json").get("placeholderText");
        Assert.assertEquals(homePage.verifyPlaceholder(), placeholderText);
    }


    @Test(description = "Verify on different tabs and verify title")
    public void verifyTitleonTabs() throws IOException, ParseException {
        JSONArray titles = (JSONArray) ReadJson.readJsonData("article.json").get("titlesToBeVerified");
        for (Object title : titles)
            Assert.assertTrue(homePage.verifyTitleonTabs((String) title));

    }

    @Test(description = "Verify Footer of the page")
    public void verifyFooter() throws IOException, ParseException {
        String category = (String) readJson.readJsonData("article.json").get("categories");
        String information = (String) readJson.readJsonData("article.json").get("information");
        String myAccount = (String) readJson.readJsonData("article.json").get("myAccount");
        homePage.verifyFotter(category, information, myAccount);

    }


}
