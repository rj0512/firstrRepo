package pageobjects;


import base.TestBaseSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import utilities.TestUtility;

import java.util.List;


public class Homepage extends TestBaseSetup {

    @FindBy(xpath = "//*[@id='header_logo']//img")
    public WebElement siteLogo;

    @FindBy(xpath = "//span[@class='shop-phone']//strong")
    public WebElement headerCallUsNowNumber;

    @FindBy(xpath = "//*[@class='shop-phone']")
    public WebElement headerCallUsNowText;

    @FindBy(id = "search_query_top")
    public WebElement placeHolderText;

    @FindBy(xpath = "//*[@class='logout' and normalize-space(text())='Sign out']")
    public WebElement logoutText;

    @FindBy(xpath = "//h4[contains(text(),'Categories')]")
    public WebElement categoriesText;

    @FindBy(xpath = "//*[contains(@id,'block_various_links_footer')]//ul//li")
    public List<WebElement> informationList;

    @FindBy(xpath = "(//ul[@class='tree dynamized']//li)[1]")
    public WebElement categoriesList;

    @FindBy(xpath = "//ul[@class='bullet']//li")
    public List<WebElement> myaccountList;

    @FindBy(xpath = "//h4[contains(text(),'Information')]")
    public WebElement informationText;

    @FindBy(xpath = "//a[contains(text(),'My account')]")
    public WebElement myAccountText;

    @FindBy(xpath = "//*[normalize-space(text())='Faded Short Sleeve T-shirts']")
    public WebElement productName;

    @FindBy(xpath = "//*[@id='homefeatured']/li']")
    public List<WebElement> productList;

    @FindBy(id = "add_to_cart")
    public WebElement addToCart;

    @FindBy(xpath = "//*[@id='homefeatured']/li']")
    public List<WebElement> verifyTitleonTabs1;

    @FindBy(xpath = "//*[@id='homefeatured']/li']")
    public List<WebElement> verifyTitleonTabs2;

    public boolean verifyPagetitle(String title) {
        System.out.println("title"+driver.getTitle());
        return driver.getTitle().equals(title);

    }

    public boolean verifyTitleonTabs(String title) {
        driver.findElement(By.xpath("(//a[@title='" + title + "'])[last()]")).click();
        return driver.getTitle().equals(title + " - My Store");
    }

    public boolean verifyLogo() {

        return siteLogo.isDisplayed();
    }

    public String verifyPlaceholder() {

        return placeHolderText.getAttribute("placeholder");
    }


    public boolean verifyLogoutText() {
        return logoutText.isDisplayed();

    }


    public boolean callUs(String str) {

        Assert.assertTrue(headerCallUsNowText.isDisplayed());
        return headerCallUsNowNumber.getText().equals(str);

    }

    public void verifyFotter(String category, String info, String myaccount) {


        WebElement categoriesEle = categoriesText;
        Assert.assertEquals(categoriesEle.getText(), category);
        System.out.println(categoriesList.getText());


        WebElement infoEle = informationText;
        Assert.assertEquals(infoEle.getText(), info);
        List<WebElement> listinfo = informationList;
        for (WebElement wl : listinfo) {
            System.out.println(wl.getText());
        }


        WebElement accEle = myAccountText;
        Assert.assertEquals(accEle.getText(), myaccount);
        List<WebElement> acccate = myaccountList;
        for (WebElement wl : acccate) {
            System.out.println(wl.getText());
        }
    }




    public void clickOnProduct() {
        productName.click();
    }

    public void goToDashbaord() {
        siteLogo.click();
    }



}

