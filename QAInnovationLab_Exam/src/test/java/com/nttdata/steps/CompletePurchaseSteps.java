package com.nttdata.steps;

import com.nttdata.page.CarritoPage;
import com.nttdata.page.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CompletePurchaseSteps {
    private WebDriver driver;

    //constructor
    public CompletePurchaseSteps(WebDriver driver){
        this.driver = driver;
    }

    public void buttonPurchase(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement obAmountProduct = wait.until(
                ExpectedConditions.elementToBeClickable(CarritoPage.buttonFinishPurchase));
        obAmountProduct.click();
    }
}