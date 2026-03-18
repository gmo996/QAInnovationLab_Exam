package com.nttdata.steps;

import com.nttdata.page.CarritoPage;
import com.nttdata.page.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Keys;

import java.time.Duration;

public class AddCartSteps {
    private WebDriver driver;

    //constructor
    public AddCartSteps(WebDriver driver){
        this.driver = driver;
    }

    public void addFirstProduct(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement obFristProduct = wait.until(
                ExpectedConditions.elementToBeClickable(CarritoPage.primerProducto));
        obFristProduct.click();
    }

    public void addQuantity(int n_quantity){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement obButtonQuantity = wait.until(
                ExpectedConditions.elementToBeClickable(CarritoPage.inputCantidad));
        obButtonQuantity.click();
        obButtonQuantity.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
        obButtonQuantity.sendKeys(String.valueOf(n_quantity));
    }

    public void addKart(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement obButtonKart = wait.until(
                ExpectedConditions.elementToBeClickable(CarritoPage.buttonAddCart));
        obButtonKart.click();
    }

    public void addingProducts(int n_quantity) {
        addFirstProduct();
        addQuantity(n_quantity);
        addKart();
    }
}