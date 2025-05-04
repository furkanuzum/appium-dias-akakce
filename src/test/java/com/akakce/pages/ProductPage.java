package com.akakce.pages;

import org.openqa.selenium.WebElement;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class ProductPage extends BasePage{
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Satıcıya Git\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeLink[@name=\"Satıcıya Git\"]")
    private WebElement goToSeller;

    public void isOpened() {
        waitForVisibility(goToSeller);
    }
}
