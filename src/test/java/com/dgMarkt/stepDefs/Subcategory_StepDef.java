package com.dgMarkt.stepDefs;

import com.dgMarkt.pages.SubCategoryPage;
import static com.dgMarkt.utilities.BrowserUtils.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Subcategory_StepDef {

    SubCategoryPage subCategoryPage=new SubCategoryPage();

    @Given("the user select the {string}")
    public void the_user_select_the(String category) {
        subCategoryPage.categoryMenuM(category);
        waitFor(5);

    }

    @When("the user selects between {int}  and {int} by using the Price slider")
    public void theUserSelectsBetweenAndByUsingThePriceSlider(int first, int last) throws InterruptedException{
        subCategoryPage.priceslider_mth(first,last);
        waitFor(10);

    }



    @Then("Verify that the user should be able to bring the products in the price range")
    public void verify_that_the_user_should_be_able_to_bring_the_products_in_the_price_range() {

    }

}
