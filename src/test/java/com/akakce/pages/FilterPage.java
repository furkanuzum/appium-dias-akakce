package com.akakce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class FilterPage extends BasePage{

    
    @AndroidFindBy(id = "com.akakce.akakce:id/apply")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[(contains(@name, \" Ürünleri Gör\"))]")
    private WebElement showProductsButton;
    
    public FilterPage filterByBrand(String brandName) {
        //android.widget.TextView[@text="Acer"]
        By brandButton = isAndroid() ? By.xpath("//android.widget.TextView[@text=\"" + brandName + "\"]")
                : By.id(brandName);
        click(brandButton);
        return this;
    }

    public SearchPage applyFilters(){
        click(showProductsButton);
        return new SearchPage();
    }
}
