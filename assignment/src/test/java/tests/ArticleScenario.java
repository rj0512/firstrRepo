package tests;

import base.TestBaseSetup;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pojo.ArticlePojo;
import pojo.UserPojo;
import utilities.Log;

import java.io.IOException;
import java.util.Arrays;
import java.util.Locale;

import static interfaces.ClassObject.*;

public class ArticleScenario extends TestBaseSetup {

    String email, userName, password;

    @BeforeClass

    public void intialzeLoginData() throws IOException, ParseException {

        email = (String) readJson.readJsonData("employee.json").get("email");
        password = (String) readJson.readJsonData("employee.json").get("password");
        userName = (String) readJson.readJsonData("employee.json").get("username");

    }


    @Test
    public void verifySignUpUser() throws InterruptedException, IOException, ParseException {
        Log.startLog("verifySignUpUser");
        String userName = (String) readJson.readJsonData("employee.json").get("username") + getAlphaNumericString(5).toLowerCase(Locale.ROOT);
        String email = getAlphaNumericString(5) + (String) readJson.readJsonData("employee.json").get("email");
        String password = (String) readJson.readJsonData("employee.json").get("password");


        UserPojo user = new UserPojo();
        user.setEmail(email);
        user.setUsername(userName);
        user.setPassword(password);

        UserPojo user2 = new UserPojo(userName, email, password);

        signUp.signUpUser(user2);
        Thread.sleep(1000);

        Assert.assertTrue(driver.findElement(By.xpath("//a[normalize-space(text()) = '" + userName + "']")).isDisplayed());

        signIn.signOutUser();

    }
    @Test
    public void verifySignUpwithUsedUsername() throws InterruptedException, IOException, ParseException {
        Log.startLog("verifySignUpwithUsedUsername");
        String userName = (String) readJson.readJsonData("employee.json").get("username");
        String email = getAlphaNumericString(5) + (String) readJson.readJsonData("employee.json").get("email");
        String password = (String) readJson.readJsonData("employee.json").get("password");
        String erromsg = (String) readJson.readJsonData("employee.json").get("usernameerrormsg");
        UserPojo user = new UserPojo(userName, email, password);
        signUp.signUpUserwithUsedName(user);
        Assert.assertEquals(erromsg,driver.findElement(By.xpath("//*[@class='error-messages']")).getText());


    }

    @Test
    public void verifySignIn() throws InterruptedException, IOException, ParseException {
        signIn.signInUser(email, password);
        Thread.sleep(2000);
        Assert.assertTrue(driver.findElement(By.xpath("//a[normalize-space(text()) = '" + userName + "']")).isDisplayed());
        signIn.signOutUser();

    }



    @Test
    public void verifyAddArticle() throws InterruptedException, IOException, ParseException {
        JSONObject addArticleObj = (JSONObject) readJson.readJsonData("article.json").get("addArticle");
        String articleTitle = (String) addArticleObj.get("articleTitle");
        // String articleAbout = (String) ((JSONObject) readJson.readJsonData("article.json").get("addArticle")).get("articleAbout");
        String articleAbout = (String) addArticleObj.get("articleAbout");
        String artilceDescription = (String) addArticleObj.get("articleDesc");
        String[] artilceTag = ((String) addArticleObj.get("tags")).split(",");
        signIn.signInUser(email, password);
        Thread.sleep(5000);
        ArticlePojo articlePojo = new ArticlePojo(articleTitle, articleAbout, artilceDescription, artilceTag);
        article.addArticle(articlePojo);
        Thread.sleep(5000);
        Assert.assertEquals(articleTitle, driver.findElement(By.xpath("//div[@class='container']//h1")).getText());

        Assert.assertEquals(artilceDescription, driver.findElement(By.xpath("//div[@class='col-md-12']//p")).getText());
        for (WebElement web : driver.findElements(By.xpath("//*[@class='tag-list']/li"))) {
            Arrays.asList(artilceTag).contains(web.getText());
        }
        signIn.signOutUser();
    }

   @Test
    public void verifyEditArticle() throws InterruptedException, IOException, ParseException {
        JSONObject addArticleObj = (JSONObject) readJson.readJsonData("article.json").get("addArticle");
        String addArticleTitle = (String) addArticleObj.get("articleTitle");
        String addArticleAbout = (String) addArticleObj.get("articleAbout");
        String addArtilceDescription = (String) addArticleObj.get("articleDesc");
        String[] addArtilceTag = ((String) addArticleObj.get("tags")).split(",");
        ArticlePojo addArticlePojo = new ArticlePojo(addArticleTitle, addArticleAbout, addArtilceDescription, addArtilceTag);

        JSONObject editArticleObj = (JSONObject) readJson.readJsonData("article.json").get("editArticle");
        String articleTitle = (String) editArticleObj.get("articleTitle");
        String articleAbout = (String) editArticleObj.get("articleAbout");
        String artilceDescription = (String) editArticleObj.get("articleDesc");
        String[] artilceTag = ((String) editArticleObj.get("tags")).split(",");
        signIn.signInUser(email, password);

        ArticlePojo articlePojo = new ArticlePojo(articleTitle, articleAbout, artilceDescription, artilceTag);
        article.addArticle(addArticlePojo);
        article.editArticle(articlePojo);
        Thread.sleep(5000);
        Assert.assertEquals(articleTitle, driver.findElement(By.xpath("//div[@class='container']//h1")).getText());
        Assert.assertEquals(artilceDescription, driver.findElement(By.xpath("//div[@class='col-md-12']//p")).getText());
        System.out.println();
        for (WebElement web : driver.findElements(By.xpath("//*[@class='tag-list']/li"))) {
            Arrays.asList(artilceTag).contains(web.getText());

        }
        signIn.signOutUser();


    }

  @Test
    public void verifyDeleteArticle() throws InterruptedException, IOException, ParseException {
        JSONObject addArticleObj = (JSONObject) readJson.readJsonData("article.json").get("addArticle");
        String articleTitle = "First Delete Article";
        String articleAbout = (String) addArticleObj.get("articleAbout");
        String artilceDescription = (String) addArticleObj.get("articleDesc");
        String[] artilceTag = ((String) addArticleObj.get("tags")).split(",");
        signIn.signInUser(email, password);
        Thread.sleep(5000);
        ArticlePojo articlePojo = new ArticlePojo(articleTitle, articleAbout, artilceDescription, artilceTag);
        article.addArticle(articlePojo);
        Thread.sleep(5000);
        article.gotoDashboard();
        article.gotoGlobalFeed();
        Assert.assertEquals(articleTitle, driver.findElement(By.xpath("//*[@class='preview-link']//h1")).getText());
        article.gotoFirstArticleonGlobalFeed();
        article.deleteArticle();
        article.gotoGlobalFeed();
        Assert.assertNotEquals(articleTitle, driver.findElement(By.xpath("//*[@class='preview-link']//h1")).getText());
        signIn.signOutUser();
    }

 @Test
    public void verifyAddComment() throws InterruptedException, IOException, ParseException {
        JSONObject addArticleObj = (JSONObject) readJson.readJsonData("article.json").get("addArticle");
        String articleTitle = (String) addArticleObj.get("articleTitle");
        String articleAbout = (String) addArticleObj.get("articleAbout");
        String artilceDescription = (String) addArticleObj.get("articleDesc");
        String[] artilceTag = ((String) addArticleObj.get("tags")).split(",");
        JSONObject addCommentObj = (JSONObject) readJson.readJsonData("article.json").get("addComment");
        String comment = (String) addCommentObj.get("comment");

        signIn.signInUser(email, password);
        ArticlePojo articlePojo = new ArticlePojo(articleTitle, articleAbout, artilceDescription, artilceTag);
        article.addArticle(articlePojo);
        Thread.sleep(5000);
        article.postComment(comment);
      Thread.sleep(5000);
        Assert.assertEquals(comment,driver.findElement(By.xpath("//*[@class='card-text']")).getText());
        signIn.signOutUser();
    }

  @Test
    public void verifyDeleteComment() throws InterruptedException, IOException, ParseException {
        JSONObject addArticleObj = (JSONObject) readJson.readJsonData("article.json").get("addArticle");
        String articleTitle = (String) addArticleObj.get("articleTitle");
        String articleAbout = (String) addArticleObj.get("articleAbout");
        String artilceDescription = (String) addArticleObj.get("articleDesc");
        String[] artilceTag = ((String) addArticleObj.get("tags")).split(",");
        JSONObject addCommentObj = (JSONObject) readJson.readJsonData("article.json").get("addComment");
        String comment = (String) addCommentObj.get("comment");

        signIn.signInUser(email, password);
        ArticlePojo articlePojo = new ArticlePojo(articleTitle, articleAbout, artilceDescription, artilceTag);
        article.addArticle(articlePojo);
            article.postComment(comment);
        Thread.sleep(10000);
        article.deleteComment();
        //Assert.assertNotEquals(comment,driver.findElement(By.xpath("//*[@class='card-text']")).getText());
        signIn.signOutUser();
    }

    @AfterClass
    public  void endClass(){
        Log.endLog();
    }

}