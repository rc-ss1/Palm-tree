package com.cucumber.commonservices;

import com.cucumber.commonbase.Base;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.openqa.selenium.By;

import java.time.Duration;
    public class WaitHelper extends Base {

        private final By spinnerLocatorBeforeEvent = By.xpath("//*[@id='LoderSvg']");
        private final By spinnerLocatorAfterEvent = By.xpath("//app-master//*[@id='LoderSvg']");

        public static void waitSleep(){
            try{
                Thread.sleep(5000);
            }catch (Exception e){
                e.getMessage();
            }
        }
//explicit wait -static
        public void waitForElementToBeVisible(By locator) {
            WebDriverWait specificWait = new WebDriverWait(driver, Duration.ofSeconds(70));
            specificWait.until(ExpectedConditions.visibilityOfElementLocated(locator));


        }
        public void waitForElementToBeVisiblewithparameter(By locator, int sec) {
            WebDriverWait specificWait = new WebDriverWait(driver, Duration.ofSeconds(sec));
            specificWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            specificWait.until(ExpectedConditions.visibilityOfElementLocated(locator));

        }


        public void waitForSpinnerBeforeEventForSpecificTime() {
            WebDriverWait specificWait = new WebDriverWait(driver, Duration.ofSeconds(30));
            specificWait.until(ExpectedConditions.visibilityOfElementLocated(spinnerLocatorAfterEvent));
        }



        }
