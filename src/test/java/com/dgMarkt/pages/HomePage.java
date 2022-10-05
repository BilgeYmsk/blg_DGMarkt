package com.dgMarkt.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.dgMarkt.utilities.ConfigurationReader;

public class HomePage extends BasePage{

    @FindBy(xpath = "(//input[@name='mail_subscribe'])[1]")
    public WebElement newsLetter_loc;

    @FindBy(xpath = "(//button[text()='Subscribe'])[1]")
    public WebElement newsLetterSubBtn_loc;

    @FindBy(css = ".cbk_newsletter")
    public WebElement newsLetterChckBx_loc;



    @FindBy(css = ".a-close-newsletter")
    public WebElement newsLetterClose_loc;

    public void newsLetter_mthd(){

        newsLetter_loc.sendKeys(ConfigurationReader.get("email"));
        newsLetterChckBx_loc.click();
        newsLetterSubBtn_loc.click();

    }

//    *************************

    @FindBy(xpath = "//span[text()='My Account']")
    public WebElement myAccountBtn_loc;

    @FindBy(id = "pt-register-link")
    public WebElement register_loc;

    @FindBy(id = "pt-login-link")
    public WebElement login_loc;

    @FindBy(css = "#cart")
    public WebElement cartBtn;



}


