package com.cucumber.pages;

import com.cucumber.commonservices.WaitHelper;
import com.cucumber.commonbase.Base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;


public class SearchPage extends Base {

    WebDriverWait wait;
    WaitHelper waithelper;

    public SearchPage() {

        wait = new WebDriverWait(driver, Duration.ofSeconds(120));
        waithelper = new WaitHelper();
    }

    //MouseOperations mouse = new MouseOperations();
    private final By seeDetails = By.xpath("(//div[contains(text(),'See Details')])[1]");
    private final By searchResults = By.xpath("//div[@class='dfd-results']/div/child::div");
    private final By specificCake = By.xpath("//div[@class='catalogueV2heading' and normalize-space(text())='Happy Birthday Bento Ribbon Cake And 5 Cupcakes']");
    private final By productDetails = By.xpath("//h3[text()='Print your own image on the cake']");
    private final By cartOption = By.xpath("//*[@data-id='baloonX00153']");
    private final By addToCart = By.xpath("//button[@id='add_to_cart']");
    private final By cartPopUp = By.xpath("//*[@id='continue_shopping_popup']");
    private final By proceedToCheckout = By.xpath("//div[@id='chkoutbutton']");
    private final By selectAddOns = By.xpath("//div[@class='product-name' and contains(normalize-space(text()),'Paw Patrol Cartoon Theme Foil Balloon')]");
    private final By selectAddOns1 = By.xpath("//div[@class='product-name' and contains(normalize-space(text()),'Happy Birthday Cake Topper')]");
    private final By closeButton = By.xpath("//*[@id='closeModal']");


    public void enterSearch() {
        driver.findElement(By.xpath("//input[@id='search_bar_id']")).sendKeys("mobile"); //using Selenium click button method
    }



    public void clickSearch() {
        wait.until(ExpectedConditions.elementToBeClickable(By.id("search_btn")));


        WebElement clickSearch = driver.findElement(By.id("search_btn"));


        clickSearch.click();


    }

    public void enterValidText() {
        //driver.findElement(By.xpath("//input[@id='search_bar_id']")).click();
        WebElement enterText = driver.findElement(By.xpath("//input[@id='search-input']"));
        enterText.sendKeys("cake", Keys.ENTER);

    }

    public void enterInValidText() {
        WebElement enterText = driver.findElement(By.xpath("//input[@id='search_bar_id']"));
        enterText.sendKeys("#$%^&");
    }

    public String getText() {
        String getCakeText = driver.findElement(By.xpath("//*[normalize-space()='Silicone Cupcake Molds']")).getText();
        return getCakeText;
    }

    private By cakeItemsLocator = By.xpath("//div[@class='catalogueV2heading'][1]");

    // Return cake WebElements
    public List<WebElement> getAllCakeElements() {
        return driver.findElements(cakeItemsLocator);
    }

    public int getInvalidText() {
        List<WebElement> text = driver.findElements(By.xpath("//h1//span"));
        return text.size();

    }

    public void clickNext() {
        WebElement clickNext = driver.findElement(By.xpath("//a[normalize-space()='2']"));
        clickNext.click();

    }

    public String getTextOnPage2() throws InterruptedException {
        //Thread.sleep(10000);
        String getChocolateTextOnPage2 = driver.findElement(By.xpath("//div[text()='Java Love Filled Chocolate Box']")).getText();
        return getChocolateTextOnPage2;
    }

    //sameday delivery products

    public String getSameDayDeliveryText() {
        String getGameOutdoorPlayText = driver.findElement(By.xpath("Skill Throw Game, Develops Visual skills For Indoor And Outdoor Play")).getText();
        return getGameOutdoorPlayText;

    }

    //h2[text()='Top Same Day Delivery Products on Kapruka']//following-sibling::p
    //h2[text()='Top Same Day Delivery Products on Kapruka']//following::table//tr[1]
    public List<WebElement> getTableData() {

        return driver.findElements(By.xpath("//h2[text()='Top Same Day Delivery Products on Kapruka']//following::table//tr"));


    }

    public WebElement getTableText(int i) {
        return driver.findElement(By.xpath("//h2[text()='Top Same Day Delivery Products on Kapruka']//following::table//tr[" + i + "]"));


    }

    public void clickSameDayDelivery() {
        WebElement clickSameDayDelivery = driver.findElement(By.xpath("//*[contains(text(), 'Same day delivery')]"));
        clickSameDayDelivery.click();

    }

    public void scrolldown() {
        // Assuming 'driver' is your WebDriver instance
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Assuming 'element' is the WebElement you want to scroll to
        WebElement element = driver.findElement(By.xpath("//*[text()='Top Same Day Delivery Products on Kapruka']"));

        js.executeScript("arguments[0].scrollIntoView(true);", element);
//if true -> element is aligned at the screen
        //if false - > element is at the bottom of the screen



//        js.executeScript("document.getElementById('user_email_login').value='rbc@xyz.com';");
//        js.executeScript("document.getElementById('user_password').value='password';");
//        js.executeScript("document.getElementById('user_submit').click();");
//        js.executeScript("alert('enter correct login credentials to continue');");


    }

    public List<WebElement> getDetailsOfProducts() {
        return driver.findElements(searchResults);
    }

    public String getSelectedProductText() {

        return driver.findElement(productDetails).getText();
    }
    public void clickfirstCake()
    {
        driver.findElement(specificCake).click();

    }
    public void addToCart()
    {
        driver.findElement(cartOption).click();
        waithelper.waitForElementToBeVisible(addToCart);

        driver.findElement(addToCart).click();
        waithelper.waitForElementToBeVisible(cartPopUp);
        driver.findElement(cartPopUp).click();
        waithelper.waitForElementToBeVisible(proceedToCheckout);
        driver.findElement(proceedToCheckout).click();
        driver.findElement(selectAddOns).click();
        driver.findElement(closeButton).click();
    }

    //code to handle cake results using hashmap concept


    public Map<String, String> getCakeDetails() {
        Map<String, String> cakeDetails = new HashMap<>();
        List<WebElement> items = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(cakeItemsLocator));

        for (WebElement cakeItem : items) {
            try {
                String cakeName = cakeItem.findElement(By.xpath("//div[@class='catalogueV2heading'][1]")).getText().trim();
                String cakePrice = cakeItem.findElement(By.xpath("//div[@class='CatalogueV2price'][1]")).getText().trim();
                cakeDetails.put(cakeName, cakePrice);
            } catch (NoSuchElementException e) {
                System.out.println("Element not found in one of the cake items.");
            }
        }
        return cakeDetails;
    }

    }