package com.nttdata.steps;

import com.nttdata.page.CarritoPage;
import com.nttdata.page.HomePage;
import com.nttdata.page.LoginPage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class LoginSteps {

    private WebDriver driver;

    //constructor
    public LoginSteps(WebDriver driver){
        this.driver = driver;
    }

    public void inLoginPage(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement intoLoginPage = wait.until(
                ExpectedConditions.elementToBeClickable(LoginPage.loginButton));
        intoLoginPage.click();
    }

    public void typeUser(String user){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement userInputElement = wait.until(
                ExpectedConditions.visibilityOfElementLocated(LoginPage.userInput)
        );
        userInputElement.sendKeys(user);

    }

    /**
     * Escribir el password
     * @param password el password del usuario
     */
    public void typePassword(String password){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement passwordInputElement = wait.until(
                ExpectedConditions.visibilityOfElementLocated(LoginPage.passInput)
        );
        passwordInputElement.sendKeys(password);
    }

    /**
     * Hacer click en el botón login
     */
    public void login(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement buttonLogin = wait.until(
                ExpectedConditions.visibilityOfElementLocated(LoginPage.logsummitButton)
        );
        buttonLogin.click();
    }

    public String checkAuth(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement titleLoggin = wait.until(
                ExpectedConditions.visibilityOfElementLocated(HomePage.check_logging));
        String actual = titleLoggin.getText().replace("", "").trim();
        Assertions.assertEquals("Cerrar sesión", actual, "No se logró loguear");
        return titleLoggin.getText();
    }

    public void ingresoUsuarioYClave(String user, String password) {
        inLoginPage();
        typeUser(user);
        typePassword(password);
        login();
        checkAuth();
    }
}
