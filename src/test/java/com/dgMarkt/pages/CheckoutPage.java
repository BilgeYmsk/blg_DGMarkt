package com.dgMarkt.pages;

import com.dgMarkt.pages.BasePage;
import com.dgMarkt.utilities.BrowserUtils;
import com.dgMarkt.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static com.dgMarkt.utilities.BrowserUtils.scrollToElement;
import static com.dgMarkt.utilities.BrowserUtils.waitFor;
import static org.junit.Assert.assertTrue;

public class CheckoutPage extends BasePage {
    @FindBy(xpath = "//input[@id='button-payment-address']")
    public WebElement billingContinueBtn;

    @FindBy(xpath = "//input[@id='button-shipping-address']")
    public WebElement deliveryContinueBtn;

    @FindBy(xpath = "//div[@id='collapse-shipping-method']//label[1]")
    public WebElement flatRate;

    @FindBy(xpath = "(//input[@id='button-shipping-method'])[1]")
    public WebElement flatRateContinueBtn;

    @FindBy(xpath = "//input[@name='agree']")
    public WebElement agreeBtn;

    @FindBy(xpath = "//input[@id='button-payment-method']")
    public WebElement paymentContinueBtn;

    /**
     * verify that confirm order has selected currency
     * @param product
     * @param currency
     */
    public void verifyingConfirOrderCurrency(String product, String currency){
        WebElement price = Driver.get().findElement(By.xpath("//td[@class='text-left']//a[contains(text(),'"+product+"')]//..//..//td[4]"));
        //System.out.println(price.getAttribute("innerHTML")); tag in icindeki text varsa texti
        //System.out.println(price.getAttribute("outerHTML")); tag in icindeki herseyi yazdirir
        assertTrue(price.getAttribute("innerHTML").contains(currency));
    }
    public void billingAndDeliveryDetails(){
        scrollToElement(billingContinueBtn);
        waitFor(1);
        billingContinueBtn.click();

        scrollToElement(deliveryContinueBtn);
        waitFor(1);
        deliveryContinueBtn.click();
    }

    public void verifyingFlatRate(String currency){
        waitFor(1);
        assertTrue(flatRate.getText().contains(currency));
        flatRateContinueBtn.click();
    }
    public void copmletePayment(){
        agreeBtn.click();
        paymentContinueBtn.click();
    }

    @FindBy(name = "agree")
    public WebElement agreeCheckbox;

    @FindBy(name = "comment")
    public List<WebElement> commentArea;

    @FindBy(xpath = "//h1[normalize-space()='Your order has been placed!']")
    public WebElement orderSuccessText;

    @FindBy(xpath = "//div[@class='text-danger']")
    public List<WebElement> errorMessagesList;

    @FindBy(xpath = "//input[@type='text']")
    public List<WebElement> inputList;

    @FindBy(css = ".alert.alert-danger.alert-dismissible")
    public WebElement agreeError;


    public String deliveryTexts(String containsText) {
        BrowserUtils.waitFor(2);
        return Driver.get().findElement(By.xpath("//p[contains(text(),'" + containsText + "')]")).getText();
    }

    public WebElement details(String detail) {
        BrowserUtils.waitFor(2);
        return Driver.get().findElement(By.id(detail));
    }

    public WebElement continueButtons(String id) {
        WebElement element = Driver.get().findElement(By.id(id));
        BrowserUtils.waitFor(2);
        return element;
    }

    public void enterTheInputs(String id, String firstName, String lastName, String company, String address_1, String address_2, String city, String pastCode, String country, String regionState) throws NoSuchElementException {
        try {
            if (!Driver.get().findElement(By.id(id)).isDisplayed()) {
                for (int i = 1; i < 8; i++) {

                    switch (i) {
                        case 1 -> inputList.get(i).sendKeys(firstName);
                        case 2 -> inputList.get(i).sendKeys(lastName);
                        case 3 -> inputList.get(i).sendKeys(company);
                        case 4 -> inputList.get(i).sendKeys(address_1);
                        case 5 -> inputList.get(i).sendKeys(address_2);
                        case 6 -> inputList.get(i).sendKeys(city);
                        default -> inputList.get(i).sendKeys(pastCode);
                    }
                    new Select(details("input-payment-country")).selectByVisibleText(country);
                    details("input-payment-zone").sendKeys(regionState);
                }
            }else {
                continueButtons("button-payment-address").click();
            }

        }catch (NoSuchElementException noSuchElementException){
            for (int i = 1; i < 8; i++) {

                switch (i) {
                    case 1 -> inputList.get(i).sendKeys(firstName);
                    case 2 -> inputList.get(i).sendKeys(lastName);
                    case 3 -> inputList.get(i).sendKeys(company);
                    case 4 -> inputList.get(i).sendKeys(address_1);
                    case 5 -> inputList.get(i).sendKeys(address_2);
                    case 6 -> inputList.get(i).sendKeys(city);
                    default -> inputList.get(i).sendKeys(pastCode);
                }
                new Select(details("input-payment-country")).selectByVisibleText(country);
                details("input-payment-zone").sendKeys(regionState);
            }
            continueButtons("button-payment-address").click();
        }
    }

    public WebElement radioButtons(String value) {
        return Driver.get().findElement(By.xpath("//*[@value='" + value + "']"));
    }

}

