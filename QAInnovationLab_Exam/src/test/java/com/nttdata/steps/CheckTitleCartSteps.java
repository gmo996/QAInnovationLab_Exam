package com.nttdata.steps;

import com.nttdata.page.CarritoPage;
import com.nttdata.page.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckTitleCartSteps {
    private WebDriver driver;

    //constructor
    public CheckTitleCartSteps(WebDriver driver){
        this.driver = driver;
    }

    public String checkNamePage(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement titlePage = wait.until(
                ExpectedConditions.visibilityOfElementLocated(CarritoPage.titleCartPage));
        return titlePage.getText();
    }
}