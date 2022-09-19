package com.dgMarkt.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.dgMarkt.utilities.ConfigurationReader;
import com.dgMarkt.utilities.Driver;

public class LoginPanel_Page2 extends BasePage{


    public void loginPanel_mthd2(String name){


        WebElement panel= Driver.get().findElement(By.xpath("//input[@name='"+name+"']"));

        if(name.equalsIgnoreCase("email")){
            panel.sendKeys(ConfigurationReader.get("B3_email"));
        }else if(name.equalsIgnoreCase("password")){
            panel.sendKeys(ConfigurationReader.get("B3_password"));
        }else if(name.equalsIgnoreCase("login")){
            panel.click();
        }

    }
}
