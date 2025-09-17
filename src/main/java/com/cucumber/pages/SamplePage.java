package com.cucumber.pages;


import com.cucumber.commonbase.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SamplePage extends Base {

    public SamplePage() {
        this.driver = driver;
    }

    // Example locator: replace with the actual locator for the link that opens a new window
    private By openNewWindowLink = By.cssSelector("a[target='_blank']");

    public void open(String url) {
        driver.get(url);
    }

    // Clicks the first link that opens in a new window (target=_blank)
    public void clickOpenNewWindowLink() {
        WebElement link = driver.findElement(openNewWindowLink);
        link.click();
    }
}