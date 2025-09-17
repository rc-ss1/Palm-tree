package com.cucumber.pages;

import com.cucumber.commonbase.Base;
import org.openqa.selenium.By;

public class SamedayDeliveryPage extends Base {

    // Locators

    private By productCards = By.xpath("//div[@class='catalogueV2heading']");
    private By searchBox = By.xpath("//input[@id='search-input']");
    private By textDisplayed = By.xpath("//span[@class='event_title' and text()='SAME DAY DELIVERY BEST SELLERS']");


    // Actions
    public String getPageTitle() {
        return driver.getTitle();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public int getProductCount() {
        return driver.findElements(productCards).size();
    }

    public boolean isSearchBoxPresent() {
        return driver.findElement(searchBox).isDisplayed();
    }

    public boolean isTextDisplayed() {
        return driver.findElement(textDisplayed).isDisplayed();
    }
}
