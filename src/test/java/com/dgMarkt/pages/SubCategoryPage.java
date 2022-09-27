package com.dgMarkt.pages;

import static com.dgMarkt.utilities.BrowserUtils.*;
import com.dgMarkt.utilities.Driver;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.Collections;
import java.util.List;


public class SubCategoryPage extends BasePage {
    @FindBy(xpath = "(//div[@id='slider-price']//span)[1]")
    public WebElement priceRight_loc;

    @FindBy(xpath = "(//div[@id='slider-price']//span)[2]")
    public WebElement priceLeft_loc;

    @FindBy(xpath = "//input[@id='price-from']")
    public WebElement priceFrom_loc;

    @FindBy(xpath = "//input[@id='price-to']")
    public WebElement priceTo_loc;

    @FindBy(xpath = "//select[@id='input-sort']//option")
    public List<WebElement> sortBy_list_loc;

    @FindBy(xpath = "(//h3[text()='Categories'])[2]")
    public WebElement categoryText;

    public void priceslider_mth_Blg(int begin, int finish) throws InterruptedException {

        waitFor(5);
        scrollToElement(priceRight_loc);
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


        for (int i = 102; i < begin; i++) {
            priceRight_loc.sendKeys(Keys.ARROW_RIGHT);
        }

        waitFor(5);

        scrollToElement(priceLeft_loc);

//        for (int i = 450; i < finish; i--) {
//            priceLeft_loc.sendKeys(Keys.ARROW_LEFT);
//        }
//        waitFor(3);

    }

    public void priceslider_mth(String currency, int down, int top) throws InterruptedException {

        int start = 0;
        int finish = 0;
        waitForClickablility(priceRight_loc, 10);

            if (currency.equalsIgnoreCase("$ US Dollar")) {
                start = 102; finish = 485;
            } else if (currency.equalsIgnoreCase("£ Pound Sterling")) {
                start = 63; finish = 297;
            } else if (currency.equalsIgnoreCase("€ Euro ")) {
                start = 81; finish = 381;
            }

        for (int i=start; i < down; i++) {
            Thread.sleep(500);
            priceRight_loc.sendKeys(Keys.ARROW_RIGHT);
        }

        for (int i=finish; i > top; i--) {
            Thread.sleep(500);
            priceLeft_loc.sendKeys(Keys.ARROW_LEFT);
        }


        System.out.println("priceFrom_loc.getAttribute(\"value\") = " + priceFrom_loc.getAttribute("value"));
        System.out.println("priceTo_loc.getAttribute(\"value\") = " + priceTo_loc.getAttribute("value"));

        //waitFor(1);
        // BrowserUtils.scrollToElement(priceRight_loc);

//       int xwidth=priceRight_loc.getSize().width;
//        System.out.println("xwidth = " + xwidth);
//        Actions move = new Actions(Driver.get());
//       // Action action = move.dragAndDropBy(priceRight_loc, 100,0).build();
//       // action.perform();
//        move.dragAndDropBy(priceRight_loc, xwidth*10,0);
//        move.build().perform();
//
//        waitFor(2);
//
//        System.out.println("priceFrom_loc.getAttribute(\"value\") = " + priceFrom_loc.getAttribute("value"));
//
//        Action action2=move.dragAndDropBy(priceLeft_loc,-130,0).build();
//        action2.perform();
//
//        System.out.println("priceTo_loc.getAttribute(\"value\") = " + priceTo_loc.getAttribute("value"));
//


        //System.out.println("sliderEnd_loc = " + sliderEnd_loc);


    }

    @FindBy(xpath = "//select[@id='input-sort']")
    public WebElement sort_by_loc;

    @FindBy(xpath = "//select[@id='input-sort']//option")
    public List<WebElement> sort_list_loc;

    @FindBy(xpath = "//select[@id='input-limit']")
    public WebElement show_Loc;

    @FindBy(xpath = "//select[@id='input-limit']//option")
    public List<WebElement> show_List_loc;

    @FindBy(xpath = "//div[@class='box-price']//p")
    public List<WebElement> box_price_list_loc;

    @FindBy(xpath = "//div[@class='col-sm-6 text-right']")
    public WebElement product_Stuck_text_Loc;

    public void verify_Slider(String currency,int down, int top) {
        waitFor(1);
        sort_by_loc.click();
        waitFor(1);
        for (WebElement sort : sort_list_loc) {
            if (sort.getText().equalsIgnoreCase("Price (Low > High)")) {
                sort.click();
            }
        }

        waitFor(1);
        show_Loc.click();
        waitFor(1);
        for (WebElement show : show_List_loc) {
            if (show.getText().equalsIgnoreCase("100")) {
                show.click();
            }
        }



//        List<String> sortedProductPrices = getElementsText(priceList);
//        String down_str = sortedProductPrices.get(0).replace(currency,"");
//        String top_str = sortedProductPrices.get(sortedProductPrices.size() - 1).replace(currency,"");
//        int actual_down= Integer.parseInt(down_str);
//        int actual_top= Integer.parseInt(top_str);
//
//        System.out.println("actual_down = " + actual_down);
//        System.out.println("actual_down = " + actual_top);

//        boolean verify= false;
//       if(actual_down>down && actual_top<top){
//           verify=true;
//       }

        String down_String = box_price_list_loc.get(0).getText().trim().replace(currency,"");
        double down_double= Double.parseDouble(down_String);
        System.out.println("down_Limit = " + down_double);
        waitFor(2);
        scrollToElement(box_price_list_loc.get(box_price_list_loc.size() - 1));
        waitFor(1);
        String top_String = box_price_list_loc.get(box_price_list_loc.size() - 1).getText().trim().replace(currency,"");
        double top_double= Double.parseDouble(top_String);
        System.out.println("top_limit = " + top_double);

        assertTrue(down_double>down && top_double<top);

//        Showing 1 to 23 of 23 (1 Pages)

////        String[] split = product_Stuck_text_Loc.getText().split("");
//        String split = product_Stuck_text_Loc.getText().strip();
//        int deger= Integer.parseInt(split[5]);
//        System.out.println("deger = " + deger);


//        String stuck = product_Stuck_text_Loc.getText().replace(" (1 Pages)","");
//        String stuck2 = stuck.replace("Showing 1 to ","");
//        System.out.println("stuck2 = " + stuck2);



    }

    public void clickProduct(String productName, String category) {
        categoryMenuM(category);
        waitFor(2);
        WebElement productLoc = Driver.get().findElement(By.xpath("//div[@class='product-item']//img[@title='" + productName + "']"));
        scrollToElement(productLoc);
        productLoc.click();


    }
    //**********  SortBy   ******************

    @FindBy(className = "form-control")
    public WebElement defaultButton;

    @FindBy (className = "//div[@class='product-item']")
    public List<WebElement> productList;

    @FindBy (xpath = "//p[@class='price']")
    public List<WebElement> priceList;

    public boolean sorting_Metod (String sortTab) {

        Select select = new Select(defaultButton);
        select.selectByVisibleText(sortTab);
        waitFor(1);
        boolean verify= false;

        List<String> productNames = getElementsText(productList);   // product isimlerini sakladigimiz orjinal list
        List<String> sortedProductNames = getElementsText(productList);  // p. nameleri siralayip sakladigimiz list

        Collections.sort(sortedProductNames);

        ///////////////////////

        List<String> productPrices = getElementsText(priceList);  // fiyatlarin textini kismini sakladigimiz list
        List<String> sortedProductPrices = getElementsText(priceList);  // fiyatlarin siralanmis halinin listesi

        Collections.sort(sortedProductPrices);

        if (sortTab.equals("Name (A - Z)")  || sortTab.equals("Model (A - Z)")){
            verify = sortedProductNames.equals(productNames);
        } else if (sortTab.equals("Name (Z - A)") || sortTab.equals("Model (Z - A)")) {
            Collections.reverse(sortedProductNames);
            verify = productNames.equals(sortedProductNames);
        } else if (sortTab.equals("Price (Low > High)")) {
            verify = sortedProductPrices.equals(productPrices);
        }else if(sortTab.equals("Price (High > Low)")){
            Collections.reverse(sortedProductPrices);
            verify = sortedProductPrices.equals(productPrices);
        }else {
            verify=true;
        }
        return  verify;
    }



}
