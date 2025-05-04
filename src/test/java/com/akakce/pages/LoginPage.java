package com.akakce.pages;

import org.openqa.selenium.WebElement;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class LoginPage extends BasePage{
    
    @AndroidFindBy (id = "com.akakce.akakce:id/continueWithoutRegister") 
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@name=\"Üye Olmadan Devam et\"]")
    private WebElement continueWithoutRegisterButton;

    public HomePage clickSkipRegisterButton(){
        click(continueWithoutRegisterButton);
        return new HomePage();
    }
    public boolean isOpened(){
        return find(continueWithoutRegisterButton, 10);
    }
}
