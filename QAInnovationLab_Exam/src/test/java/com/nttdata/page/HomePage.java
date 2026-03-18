package com.nttdata.page;

import org.openqa.selenium.By;

public class HomePage {

    public static By categoria(String strCategory){
        return By.xpath(String.format("//a[@href='https://qalab.bensg.com/store/es/3-%s']", strCategory));
    }
    public static By subcategoria(String strSubCategory){
        return By.xpath(String.format("//ul[@class='category-sub-menu']//a[@href='https://qalab.bensg.com/store/es/4-%s']", strSubCategory));
    }
    public static By check_logging = By.xpath("//a[@class='logout hidden-sm-down']");



}
