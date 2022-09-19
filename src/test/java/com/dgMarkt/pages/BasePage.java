package com.dgMarkt.pages;

import com.dgMarkt.utilities.BrowserUtils;
import com.dgMarkt.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.dgMarkt.utilities.Driver;

public abstract class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//span[text()='My Account']")
    public WebElement myAccount;

    @FindBy(xpath = "//span[text()='Currency']")
    public WebElement currency;

    @FindBy(xpath = "//span[text()='Category']")
    public WebElement category;

    @FindBy(css = "#input-email")
    public WebElement loginEmail;

    @FindBy(css = "#input-password")
    public WebElement loginPassword;

    @FindBy(xpath = "//span[text()='Login']")
    public WebElement loginButton;

    @FindBy(css = "div.alert.alert-success")
    public  WebElement loginSuccessText;

    @FindBy(xpath = "//div[@class='dropdown-toggle search-button']")
    public WebElement search_Btn_loc;

    @FindBy(xpath = "//a[@id='wishlist-total']")
    public WebElement wish_btn_loc;

    @FindBy(xpath = "//div[@class='btn-group btn-block']")
    public WebElement shopping_cart_loc;


    public void loginM() {
        loginEmail.sendKeys(ConfigurationReader.get("userEmail"));
        BrowserUtils.waitFor(1);
        loginPassword.sendKeys(ConfigurationReader.get("userPassword"));
        BrowserUtils.waitFor(1);
        loginButton.click();
    }

    /**
     *Feature Type:And the user navigates to "My Account" menu "Order History" tab
     * navigateTo("My Account","Order History")
     * @param module
     * @param tab
     */
    public void navigateTo(String module, String tab) {

        Driver.get().findElement(By.xpath("//span[text()='" + module + "']")).click();
        Driver.get().findElement(By.xpath("//*[text()='" + tab + "']")).click();
        BrowserUtils.waitFor(1);
    }

    /**
     *  Feature Type:Then verify that the user is on the "Order Information" page
     * @param pageName
     */
    public String textOnThePagesM(String pageName){
        String text=Driver.get().findElement(By.xpath("//a[text()='"+pageName+"']")).getText();
        return text;
    }

    /**
     *Feature Type: And the user can select from Category menu "Health & Beauty" tab
     * @param tab first letter must be capitalized
     */
    public void categoryMenuM(String tab) {
        BrowserUtils.hover(category);
        BrowserUtils.hover(Driver.get().findElement(By.xpath("//a[text()='Health & Beauty']")));
        BrowserUtils.clickWithJS(Driver.get().findElement(By.xpath("//a[text()='" + tab + "']")));
    }

}
