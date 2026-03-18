package com.nttdata.steps;

import com.nttdata.page.HomePage;
import com.nttdata.page.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class InCategorySteps {
    private WebDriver driver;

    //constructor
    public InCategorySteps(WebDriver driver){
        this.driver = driver;
    }

    public void inCategory(String strCategory){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement obCategory = wait.until(
                ExpectedConditions.elementToBeClickable(HomePage.categoria(strCategory.toLowerCase())));
        obCategory.click();
    }

    public void InSubCategory(String strSubCategory){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement obSubCategory = wait.until(
                ExpectedConditions.elementToBeClickable(HomePage.subcategoria(strSubCategory.toLowerCase()))
        );
        obSubCategory.click();
    }

    public void inCategoryTypes(String strCategory, String strSubCategory) {
        inCategory(strCategory);
        InSubCategory(strSubCategory);
    }
}