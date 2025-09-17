package com.cucumber.pages;

import com.cucumber.commonbase.Base;
import org.openqa.selenium.By;

public class CartPage extends Base {
    private final By cartButton = By.cssSelector("#addtocartbutton");


    private final By cartPrice = By.xpath("//div[@class='shcont']");




    public void clickCartButton() {

        driver.findElement(cartButton).click();
    }


    public String getCartPrice()
    {

        return driver.findElement(cartPrice).getText();
    }
    public void checkCartButton()
    {

       driver.findElement(cartButton).isDisplayed();
    }


}


