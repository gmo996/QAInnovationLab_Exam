package com.nttdata.steps;

import com.nttdata.page.CarritoPage;
import com.nttdata.page.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckProductSteps {
    private WebDriver driver;

    //constructor
    public CheckProductSteps(WebDriver driver){
        this.driver = driver;
    }

    public String checkNameProduct(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement obNameProduct = wait.until(
                ExpectedConditions.visibilityOfElementLocated(CarritoPage.checkoutNombre));
        return obNameProduct.getText();
    }
}