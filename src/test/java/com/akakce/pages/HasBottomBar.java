package com.akakce.pages;

import org.openqa.selenium.WebElement;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

abstract class HasBottomBar extends BasePage{

    
    @AndroidFindBy (id = "com.akakce.akakce:id/homePage") 
	@iOSXCUITFindBy (id = "Ana Sayfa")
    private WebElement homePageIcon;

    public HomePage clickOnHomePageIcon(){
        click(homePageIcon);
        return new HomePage();
    }
}
