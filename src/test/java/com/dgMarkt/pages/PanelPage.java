package com.dgMarkt.pages;

import com.dgMarkt.utilities.ConfigurationReader;
import com.dgMarkt.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PanelPage {

    @FindBy(xpath = "(//input[@name='mail_subscribe'])[1]")
    public WebElement newsLetter_loc;

    @FindBy(xpath = "(//button[text()='Subscribe'])[1]")
    public WebElement newsLetterSubBtn_loc;

    @FindBy(css = ".cbk_newsletter")
    public WebElement newsLetterChckBx_loc;



    public void loginPanel_mthd(String name) {

        WebElement panel = Driver.get().findElement(By.xpath("//input[@name='" + name + "']"));

        if (name.equalsIgnoreCase("email")) {
            panel.sendKeys(ConfigurationReader.get("email"));
        } else if (name.equalsIgnoreCase("password")) {
            panel.sendKeys(ConfigurationReader.get("password"));
        } else if (name.equalsIgnoreCase("login")) {
            panel.click();
        }

    }
    public void login_mtd(){
        loginPanel_mthd("email");
        loginPanel_mthd("password");
        loginPanel_mthd("login");
    }
    public void newsLetter_mthd(){

        newsLetter_loc.sendKeys(ConfigurationReader.get("email"));
        newsLetterChckBx_loc.click();
        newsLetterSubBtn_loc.click();

    }


}
