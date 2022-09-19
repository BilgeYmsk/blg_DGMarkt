package com.dgMarkt.pages.myAccount;

import static com.dgMarkt.utilities.BrowserUtils.*;

import com.dgMarkt.pages.BasePage;
import com.dgMarkt.utilities.BrowserUtils;
import com.dgMarkt.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage {

    @FindBy(xpath = "//div[@class='account-register']//h2[text()='Login or create an account']")
    public WebElement loginOrCreateAnAccount_rgstr_loc;

    @FindBy(xpath = "//input[@type='email']")
    public WebElement email_btn_loc;

    @FindBy(xpath = "//div[@class='col-sm-10']//input[@id='input-register-password']")
    public WebElement password_loc;

    @FindBy(xpath = "//div[@class='col-sm-10']//input[@id='input-confirm']")
    public WebElement confirm_loc;

    public WebElement register(String data) {

        return Driver.get().findElement(By.xpath("//input[@name='" + data + "']"));

    }

    public void fillAForm(String FirstName, String LastName, String email, String telephone, String password, String confirm) {
        register("firstname").sendKeys(FirstName);

        register("lastname").sendKeys(LastName);

        email_btn_loc.sendKeys(email);

        register("telephone").sendKeys(telephone);

        password_loc.click();
        waitFor(3);

        password_loc.sendKeys(password);

        confirm_loc.click();

        confirm_loc.sendKeys(confirm);
        waitFor(3);

        BrowserUtils.scrollToElement(continue_Btn_loc);

    }


    @FindBy(xpath = "(//input[@name='newsletter'])[1]")
    public WebElement yes_btn_loc;

    @FindBy(xpath = "(//input[@name='newsletter'])[2]")
    public WebElement no_btn_loc;

    @FindBy(xpath = "//input[@name='agree']")
    public WebElement privacy_Policy_loc;

    @FindBy(xpath = "//input[@value='Continue']")
    public WebElement continue_Btn_loc;

    @FindBy(xpath = "//h2[normalize-space()='Your Account Has Been Created!']")
    public WebElement accountCreated_msg_loc;

    @FindBy(xpath = "(//span[text()='Continue'])[1]")
    public WebElement continue2_Btn_loc;

    @FindBy(linkText = "Account")
    public WebElement account_text_loc;


//    Warnung Message

//    @FindBy(xpath = "//span[text()=' Warning: E-Mail Address is already registered!']")
//    public WebElement warnung_registeredEmail_loc;
//
//    @FindBy(xpath = "//span[text()=' Warning: You must agree to the Privacy Policy!']")
//    public WebElement warnung_privacyPolicy_loc;

    public String warnungMsg_PrivacyAndRegisteredEmail_Mtd(String actualMessage) {
        WebElement message = Driver.get().findElement(By.xpath("//span[text()=' " + actualMessage + "']"));
        return message.getText();
    }

    public String warnungMessage_Mtd(String warnungMsg) {

        String actual_warnung_Message;

        if (warnungMsg.equals("Warning: E-Mail Address is already registered!") || warnungMsg.equals("Warning: You must agree to the Privacy Policy!")) {
            actual_warnung_Message = warnungMsg_PrivacyAndRegisteredEmail_Mtd(warnungMsg);
        } else {
            WebElement message = Driver.get().findElement(By.xpath("//div[text()='" + warnungMsg + "']"));
            actual_warnung_Message = message.getText();
        }
        return actual_warnung_Message;
    }

}
