package com.cucumber.pages;

import com.cucumber.commonbase.Base;
import org.openqa.selenium.By;


public class ProductDetailsPage extends Base {
    private final By chooseFileButton = By.cssSelector("input#imageFile");
    private final By getImageText = By.xpath("//span[@class='file-info']");


    public void uploadfile()
    {
        driver.findElement(chooseFileButton).sendKeys("D:/1img/1728887803107.png");
    }
    public String getImageDetails()
    {
        return driver.findElement(getImageText).getText();
    }





}


