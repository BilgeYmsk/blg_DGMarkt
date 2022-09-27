package com.dgMarkt.stepDefs;

import com.dgMarkt.pages.SubCategoryPage;

import static com.dgMarkt.utilities.BrowserUtils.*;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Subcategory_StepDef {

    SubCategoryPage subCategoryPage = new SubCategoryPage();

    @Given("the user select the {string}")
    public void the_user_select_the(String category) {
        subCategoryPage.categoryMenuM(category);
        waitFor(5);

    }

    @And("the user selects the {string} between {int}  and {int} by using the Price slider")
    public void theUserSelectsTheBetweenAndByUsingThePriceSlider(String currencyType, int down, int top) throws InterruptedException {
        subCategoryPage.priceslider_mth(currencyType, down, top);


    }


    @Then("Verify that the user should be able to bring the products with selected {string} between {int}  and {int} in the price range")
    public void verifyThatTheUserShouldBeAbleToBringTheProductsWithSelectedBetweenAndInThePriceRange(String currency,int down, int top) {
        subCategoryPage.verify_Slider(currency,down, top);

    }



}
