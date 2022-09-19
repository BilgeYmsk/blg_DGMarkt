package com.dgMarkt.pages.myAccount;

import com.dgMarkt.pages.BasePage;
import com.dgMarkt.utilities.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPanel extends BasePage {
    @FindBy(name = "email")
    public WebElement popUpMail;

    @FindBy(name = "password")
    public WebElement popUpPassword;

    @FindBy(name = "login")
    public WebElement popUpLogin;

    @FindBy(css =".a-close-newsletter" )
    public  WebElement popUpNewsletterClose;

    public void loginPanelM(){
        popUpMail.sendKeys(ConfigurationReader.get("email"));
        popUpPassword.sendKeys(ConfigurationReader.get("password"));
        popUpLogin.click();
        popUpNewsletterClose.click();
    }
}
