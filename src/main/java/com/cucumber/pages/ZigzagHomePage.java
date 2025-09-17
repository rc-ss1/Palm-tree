package com.cucumber.pages;


import com.cucumber.commonbase.Base;


import org.openqa.selenium.By;


public class ZigzagHomePage extends Base {


    private final By styleSize = By.xpath("//*[@id='Filter-Style size-1']/following-sibling::span");
    private final By color = By.xpath("//*[@id='Filter-Color-1']");

    public void check()
    {
        driver.findElement(styleSize).click();
    }
    public String getColor()
    {
        return driver.findElement(color).getAttribute("value");

    }


}