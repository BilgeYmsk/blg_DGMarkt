package com.dgMarkt.stepDefs;

import com.dgMarkt.utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import static org.junit.Assert.*;
import com.dgMarkt.pages.HomePage;
import com.dgMarkt.pages.myAccount.RegisterPage;
import io.cucumber.java.en.When;
import static com.dgMarkt.utilities.BrowserUtils.*;

public class Register_StepDef {
    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();

    @And("The user click myAccount and select register")
    public void theUserClickMyAccountAndSelectRegister() {

        homePage.myAccountBtn_loc.click();
        waitFor(2);
        homePage.register_loc.click();

    }

    @Then("The user should see {string} page")
    public void theUserShouldSeePage(String expectedText)  {

        String actualText = registerPage.loginOrCreateAnAccount_rgstr_loc.getText();
        assertEquals(expectedText, actualText);
        waitFor(3);
        BrowserUtils.scrollToElement(registerPage.loginOrCreateAnAccount_rgstr_loc);


    }


    @When("The user enters valid {string} , {string} , {string}, {string} ,{string} , {string}")
    public void the_user_enters_valid(String FirstName, String LastName, String email, String telephone, String password, String confirm) {

        registerPage.fillAForm(FirstName, LastName, email, telephone, password, confirm);

    }

    @When("The user click Yes Button on Subscribe box")
    public void the_user_click_Yes_Button_on_Subscribe_box() {
        registerPage.yes_btn_loc.click();

    }

    @When("The user click on Privacy Policy Box")
    public void the_user_click_on_Privacy_Policy_Box() {

        registerPage.privacy_Policy_loc.click();


    }

    @When("The user click on Continue button")
    public void the_user_click_on_Continue_button()  {
        waitFor(2);
        registerPage.continue_Btn_loc.click();
        waitFor(3);

    }

    @Then("Verify that the user can be register mit valid Credentials")
    public void verify_that_the_user_can_be_register_mit_valid_Credentials() {

        String accountCreatedMsg = registerPage.accountCreated_msg_loc.getText();
        String expectedCreatedMsg = "Your Account Has Been Created!";
        assertEquals(expectedCreatedMsg, accountCreatedMsg);


    }

    @Then("The user click on second Continue button")
    public void the_user_click_on_second_Continue_button()  {
        registerPage.continue2_Btn_loc.click();
        waitFor(3);
    }

    @Then("Verify that the user can be see his Account Page")
    public void verify_that_the_user_can_be_see_his_Account_Page() {
        String actualAccountText = registerPage.account_text_loc.getText();
        System.out.println("actualAccountText = " + actualAccountText);
        String expectedAccountText = "Account";
        assertEquals(expectedAccountText, actualAccountText);

    }

    @Then("Verify that the user can be not register mit invalid Credentials")
    public void verifyThatTheUserCanBeNotRegisterMitInValidCredentials() {

        String accountCreatedMsg = registerPage.accountCreated_msg_loc.getText();
        String expectedCreatedMsg = "Your Account Has Been Created!";
        assertNotEquals(expectedCreatedMsg, accountCreatedMsg);

    }

    @Then("Verify that The user should be able to see {string} and can not be register")
    public void theUserShouldBeAbleTo(String message) {

        String actualMessage = registerPage.warnungMessage_Mtd(message);
        assertEquals(message,actualMessage);

    }



    }

