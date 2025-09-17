package com.cucumber.pages;

import com.cucumber.commonbase.Base;
import com.cucumber.commonservices.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class UploadFile extends Base {



    private final By frame = By.xpath("//frame[@name='left']");

    private final By chooseFile = By.xpath("//*[@id='imageFile']");
    String path = "C:\\KDF\\image1.png";

    public void clickChooseFile() throws InterruptedException {
        try{
            //driver.findElement(By.xpath("//span[normalize-space()='Choose a file']")).click();
            driver.findElement(By.xpath("//input[@id='imageFile']")).sendKeys(path);


            System.out.println("File uploaded");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }





    }
    public void launchWebsite(){

        //driver.get("https://testpages.eviltester.com/styled/file-upload-test.html");

        //driver.get("https://testpages.eviltester.com/styled/alerts/alert-test.html");

        driver.get("https://www.kapruka.com/shops/cakes/customCakes/personalise_cakes.jsp");
    }

    public void clickRadioOptionImage()
    {
        driver.findElement(By.id("itsanimage")).click();
    }
    public void clickSubmitButton()
    {
        driver.findElement(By.name("upload"));
    }
    public void takescreenshot() throws IOException {
        WebElement element = driver.findElement(By.name("upload"));
        File elementScreenshot = element.getScreenshotAs(OutputType.FILE);
        String elementScreenshotPath = "D:/element_screenshot.png";
        Files.copy(elementScreenshot.toPath(), Paths.get(elementScreenshotPath));
    }

    public void clickAlertBox()
    {
        driver.findElement(By.id("alertexamples")).click();
    }
    public void switchToFrame()
    {

        //driver.switchTo().frame(frame);


    }

    public void selectOptionInSameFrame()
    {
        String text = driver.findElement(By.id("left22")).getText();
        System.out.println(text);

    }
    public void selectOptionInDifferentFrame()
    {
        driver.switchTo().defaultContent();
        WebElement frame = driver.findElement(By.xpath("//frame[@name='right']"));
        driver.switchTo().frame(frame);
        String text1 = driver.findElement(By.id("right0")).getText();
        System.out.println(text1);

    }
}
