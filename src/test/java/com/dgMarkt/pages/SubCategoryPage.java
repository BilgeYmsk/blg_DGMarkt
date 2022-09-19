package com.dgMarkt.pages;

import static com.dgMarkt.utilities.BrowserUtils.*;
import com.dgMarkt.utilities.BrowserUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class SubCategoryPage extends BasePage {
    @FindBy(xpath = "(//div[@id='slider-price']//span)[1]")
    public WebElement priceRight_loc;

    @FindBy(xpath = "(//div[@id='slider-price']//span)[2]")
    public WebElement priceLeft_loc;

    @FindBy(xpath = "//input[@id='price-from']")
    public WebElement priceFrom_loc;

    @FindBy(xpath = "//input[@id='price-to']")
    public WebElement priceTo_loc;

    @FindBy(xpath = "(//h3[text()='Categories'])[2]")
    public WebElement categoryText;

    public void priceslider_mth(int begin, int finish) throws InterruptedException {

       waitFor(5);
       BrowserUtils.scrollToElement(priceRight_loc);
//        Actions move = new Actions(Driver.get());
//        Action action = move.dragAndDropBy(priceRight_loc, 102, begin).build();
//        action.perform();
//
//        waitFor(5);
//
//        System.out.println("priceFrom_loc.getAttribute(\"value\") = " + priceFrom_loc.getAttribute("value"));

//        Action action2=move.dragAndDropBy(priceLeft_loc,485,finish).build();
//        action2.perform();
//
//        System.out.println("priceTo_loc.getAttribute(\"value\") = " + priceTo_loc.getAttribute("value"));


        for (int i = 102; i <begin ; i++) {
            priceRight_loc.sendKeys(Keys.ARROW_RIGHT);
        }

        waitFor(5);

        BrowserUtils.scrollToElement(priceLeft_loc);

//        for (int i = 450; i < finish; i--) {
//            priceLeft_loc.sendKeys(Keys.ARROW_LEFT);
//        }
//        waitFor(3);

    }


}
