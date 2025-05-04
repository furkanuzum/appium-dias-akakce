package com.akakce.pages;

import org.openqa.selenium.WebElement;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class HomePage extends HasBottomBar{

    @AndroidFindBy (id = "com.akakce.akakce:id/searchTextView") 
	@iOSXCUITFindBy (id = "Neyi ucuza almak istiyorsun?")
    private WebElement searchBar;

    public SearchPage clickOnTopSearchBar(){
        click(searchBar, "click top search bar");
        return new SearchPage();
    }

    public void isOpened() {
        waitForVisibility(searchBar);
    }
}
