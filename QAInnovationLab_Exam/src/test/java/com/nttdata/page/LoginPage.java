package com.nttdata.page;

import org.openqa.selenium.By;


public class LoginPage {

    //Localizadores de elementos
    public static By userInput = By.xpath("//input[@id='field-email']");
    public static By passInput = By.xpath("//input[@id='field-password']");
    public static By loginButton = By.xpath("//span[contains(text(), 'Iniciar sesión')]");
    public static By logsummitButton = By.xpath("//button[@id='submit-login']");



}
