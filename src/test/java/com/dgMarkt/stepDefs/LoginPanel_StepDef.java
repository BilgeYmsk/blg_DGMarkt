package com.dgMarkt.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import com.dgMarkt.pages.LoginPanel_Page2;
import com.dgMarkt.utilities.ConfigurationReader;
import com.dgMarkt.utilities.Driver;

public class LoginPanel_StepDef {

    LoginPanel_Page2 loginPanelPage=new LoginPanel_Page2();


    @Given("The User should be able to get url")
    public void the_User_should_be_able_to_get_url() {
        Driver.get().get(ConfigurationReader.get("url"));

    }

    @When("User should be able to enter {string} and {string} and click {string}")
    public void user_should_be_able_to_enter_and_and_click(String email, String password, String login) {
        loginPanelPage.loginPanel_mthd2(email);
        loginPanelPage.loginPanel_mthd2(password);
        loginPanelPage.loginPanel_mthd2(login);



    }


}
