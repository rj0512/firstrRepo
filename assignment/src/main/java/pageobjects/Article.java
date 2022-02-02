package pageobjects;

import base.TestBaseSetup;
import pojo.ArticlePojo;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.TestUtility;

import java.util.List;

/**
 * Created by rjoshi on Jan, 2022
 */
public class Article extends TestBaseSetup {

    @FindBy(xpath = "//*[@class='ion-compose']")
    public WebElement linkNewArticle;

    @FindBy(xpath = "//*[@placeholder='Article Title']")
    public WebElement txtArticleTitle;

    @FindBy(xpath = "//*[@formcontrolname='description']")
    public WebElement txtArticleAbt;

    @FindBy(xpath = "//*[@formcontrolname='body']")
    public WebElement txtArticleBody;

    @FindBy(xpath = "//*[@placeholder='Enter tags']")
    public WebElement txtEnterTags;

    @FindBy(xpath = "//button[normalize-space(text()) = 'Publish Article']")
    public WebElement btnPublishArticle;

    @FindBy(xpath = "//*[normalize-space(text()) = 'Edit Article']")
    public WebElement btnEditArticle;

    @FindBy(xpath = "//*[normalize-space(text()) = 'Delete Article']")
    public WebElement btnDeleteArticle;

    @FindBy(xpath = "//*[normalize-space(text()) = 'Global Feed']")
    public WebElement linkGlobalFeed;

    @FindBy(xpath = "//*[@class='card-block']//textarea")
    public WebElement txtComment;

    @FindBy(xpath = "//*[normalize-space(text()) = 'Post Comment']")
    public WebElement btnPostComment;

    @FindBy(xpath = "//*[@class='tag-default tag-pill']//i")
    public List<WebElement> listTags;

    @FindBy(xpath = "//*[@class='navbar-brand']")
    public WebElement siteLogo;

    @FindBy(xpath = "//*[@class='preview-link']//h1")
    public WebElement firstArticleonGlobalFeed;

    @FindBy(xpath = "//*[@class='mod-options']//i")
    public WebElement deleteComment;








    public void addArticle(ArticlePojo articlePojo){
        TestUtility.clickOnElement(linkNewArticle,"New Article");
        TestUtility.clearAndEnterText(txtArticleTitle,articlePojo.getTitle(),"Title");
        TestUtility.clearAndEnterText(txtArticleAbt,articlePojo.getAbout(),"Article About");
        TestUtility.clearAndEnterText(txtArticleBody,articlePojo.getDescription(),"Article Body");
        for(String tag : articlePojo.getTags())
            TestUtility.clearAndEnterText(txtEnterTags,tag+ Keys.RETURN,"Article Tags");
       TestUtility.clickOnElement(btnPublishArticle,"Article Publishbtn");

    }

    public void editArticle(ArticlePojo articlePojo){
        TestUtility.clickOnElement(btnEditArticle,"Edit Article");
        TestUtility.clearAndEnterText(txtArticleTitle,articlePojo.getTitle(),"Title");
        TestUtility.clearAndEnterText(txtArticleAbt,articlePojo.getAbout(),"Article About");
        TestUtility.clearAndEnterText(txtArticleBody,articlePojo.getDescription(),"Article Body");
        for (WebElement removetag : listTags) {
            removetag.click();
        }
        for(String tag : articlePojo.getTags())
            TestUtility.clearAndEnterText(txtEnterTags,tag+ Keys.RETURN,"Article Tags");
        TestUtility.clickOnElement(btnPublishArticle,"Article Publishbtn");

    }

    public void gotoDashboard() throws InterruptedException {
        TestUtility.clickOnElement(siteLogo,"Site Logo");
    }

    public void gotoGlobalFeed() throws InterruptedException {
        TestUtility.clickOnElement(linkGlobalFeed,"Global feed");
        Thread.sleep(5000);
    }

    public void gotoFirstArticleonGlobalFeed() throws InterruptedException {
        TestUtility.clickOnElement(firstArticleonGlobalFeed,"First Article on Global feed");
        Thread.sleep(5000);
    }


    public void deleteArticle() throws InterruptedException {
        TestUtility.clickOnElement(btnDeleteArticle,"Delete Article");
        Thread.sleep(5000);
    }



    public void postComment(String Comment){
        TestUtility.clickOnElement(txtComment,"Comment Text Area");
        TestUtility.enterText(txtComment,Comment,"Text Area");
        TestUtility.clickOnElement(btnPostComment,"Post comment");
    }

    public void deleteComment(){
        TestUtility.clickOnElement(deleteComment,"Delete Comment");

    }

}


