package com.nttdata.stepsdefinitions;

import com.nttdata.core.DriverManager;
import com.nttdata.steps.*;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import static com.nttdata.core.DriverManager.*;

public class storeStepsDef {
    private WebDriver driver;

    @Given("estoy en la página de la tienda")
    public void estoyEnLaPáginaDeLaTienda() {
        driver = getDriver();
        driver.get("https://qalab.bensg.com/store");
        screenShot();
        DriverManager.screenShot();
    }

    @And("me logueo con mi usuario {string} y clave {string}")
    public void meLogueoConMiUsuarioYClave(String user, String password) {
        LoginSteps loginSteps = new LoginSteps(driver);
        loginSteps.ingresoUsuarioYClave(user,password);
        DriverManager.screenShot();
    }

    @When("navego a la categoria {string} y subcategoria {string}")
    public void navegoALaCategoriaYSubcategoria(String strCategory, String strSubCategory) {
        InCategorySteps inCategorySteps = new InCategorySteps(driver);
        inCategorySteps.inCategoryTypes(strCategory,strSubCategory);
        DriverManager.screenShot();
    }

    @And("agrego {int} unidades del primer producto al carrito")
    public void agregoUnidadesDelPrimerProductoAlCarrito(int n_products) {
        AddCartSteps addCartSteps = new AddCartSteps(driver);
        addCartSteps.addingProducts(n_products);
        DriverManager.screenShot();
    }

    @Then("valido en el popup la confirmación del producto agregado")
    public void validoEnElPopupLaConfirmaciónDelProductoAgregado() {
        CheckProductSteps checkProductSteps = new CheckProductSteps(driver);
        String product_name = checkProductSteps.checkNameProduct();
        String expected = "Hummingbird printed t-shirt";
        if (product_name.equals(expected)) {
            System.out.println("Correcto. Texto extraído: " + product_name);
        } else {
            System.out.println("Incorrecto. Texto extraído: " + product_name);
        }

        Assertions.assertEquals(expected, product_name);
        DriverManager.screenShot();
    }

    @And("valido en el popup que el monto total sea calculado correctamente")
    public void validoEnElPopupQueElMontoTotalSeaCalculadoCorrectamente() {
        CheckAmountSteps checkAmountSteps = new CheckAmountSteps(driver);
        String product_amount = checkAmountSteps.checkAmountKart();
        String expected = "38,24 PEN";
        if (product_amount.equals(expected)) {
            System.out.println("Correcto. Texto extraído: " + product_amount);
        } else {
            System.out.println("Incorrecto. Texto extraído: " + product_amount);
        }

        Assertions.assertEquals(expected, product_amount);
        DriverManager.screenShot();
    }

    @When("finalizo la compra")
    public void finalizoLaCompra() {
        CompletePurchaseSteps completePurchaseSteps = new CompletePurchaseSteps(driver);
        completePurchaseSteps.buttonPurchase();
        DriverManager.screenShot();
    }

    @Then("valido el titulo de la pagina del carrito")
    public void validoElTituloDeLaPaginaDelCarrito() {
        CheckTitleCartSteps checkTitleCartSteps = new CheckTitleCartSteps(driver);
        String titlePageName = checkTitleCartSteps.checkNamePage();
        String expected = "CARRITO";
        if (titlePageName.equals(expected)) {
            System.out.println("Correcto. Texto extraído: " + titlePageName);
        } else {
            System.out.println("Incorrecto. Texto extraído: " + titlePageName);
        }

        Assertions.assertEquals(expected, titlePageName);
        DriverManager.screenShot();
    }

    @And("vuelvo a validar el calculo de precios en el carrito")
    public void vuelvoAValidarElCalculoDePreciosEnElCarrito() {
        CheckFinalPriceSteps checkFinalPrice = new CheckFinalPriceSteps(driver);
        String FinalPrice = checkFinalPrice.CheckFinalPrice();
        String expected = "38,24 PEN";
        if (FinalPrice.equals(expected)) {
            System.out.println("Correcto. Texto extraído: " + FinalPrice);
        } else {
            System.out.println("Incorrecto. Texto extraído: " + FinalPrice);
        }

        Assertions.assertEquals(expected, FinalPrice);
        DriverManager.screenShot();
    }
}
