package com.akakce.pages;

import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class SearchPage extends BasePage {

    @AndroidFindBy(xpath = "(//android.widget.EditText[@resource-id=\"com.akakce.akakce:id/searchTextView\"])[2]")
    @iOSXCUITFindBy(id = "Neyi ucuza almak istiyorsun?")
    private WebElement searchTxtField;

    @AndroidFindBy(id = "com.akakce.akakce:id/sortText")
    @iOSXCUITFindBy(id = "sort-icon")
    private WebElement sortButton;

    public SearchPage enterSearchTerm(String searchTerm) {
        clear(searchTxtField);
        // String newSearchTerm = isAndroid() ? searchTerm : searchTerm+"\n";
        sendKeys(searchTxtField, searchTerm, "search term is " + searchTerm);
        // pressEnter();
        return this;
    }

    public SearchPage clickOnCategory(String name){
        By categorySelector = isAndroid() ? By.xpath("//android.widget.TextView[@resource-id=\"com.akakce.akakce:id/textView\" and @text=\""+name+"\"]"):By.id(name);
        waitForVisibility(categorySelector);
        click(categorySelector);
        return this;
    }

    public FilterPage clickOnFilter() {
        WebElement filterButton;
        if (isAndroid()) {
            filterButton = scrollToElement(By.id("com.akakce.akakce:id/filterArea"), false);
            click(filterButton);
        } else {
            //Wait for filter page to load
            find(By.xpath("//XCUIElementTypeStaticText[@name=\"Laptop ve Notebook\"]"));
            filterButton = scrollToElement(By.id("Filtrele"), false);
            filterButton.click();
        }
        return new FilterPage();
    }

    public SearchPage sortBy(String text) {
        click(sortButton, isAndroid()); // In iOS sort button's visibility is false
        By sortSelec = isAndroid() ? By.xpath(
                "//android.widget.TextView[@resource-id=\"com.akakce.akakce:id/sort_name\" and @text=\"" + text + "\"]")
                : By.id(text);
        click(sortSelec);
        return this;
    }

    private WebElement selectNthSearchItem(int n) {
        By selector = isAndroid() 
        ? By.xpath("//android.view.ViewGroup[@resource-id=\"com.akakce.akakce:id/cellContainer\"]/android.widget.TextView[@resource-id=\"com.akakce.akakce:id/name\"]") 
        : By.xpath("//XCUIElementTypeCollectionView/XCUIElementTypeCell/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeStaticText[1]");
        int maxScrolls = 10;
        int attempts = 0;
        Set<String> itemsSet = new HashSet<>();
        List<WebElement> newItems;
        do {
            
            newItems = findElements(selector);
            for (WebElement newItem : newItems) {
                String productName = newItem.getText();
                itemsSet.add(productName);
                if (itemsSet.size() == n) {
                    return newItem;
                }
            }
            scrollDown();
            attempts++;
        } while (attempts < maxScrolls);

        throw new NoSuchElementException("Couldn't find the cellContainer at index " + n);

    }

    public void selectAndClickNthSearchItem(int n) {
        WebElement nthItem = selectNthSearchItem(n);
        // nthItem.click();
        click(nthItem, isAndroid());

        By goToProductButtonSelector = isAndroid() ? By.id("com.akakce.akakce:id/detailBtnTextView") : By.xpath("//XCUIElementTypeStaticText[(contains(@name, \"Ürüne Git\"))]");
        scrollToElement(goToProductButtonSelector, true);
        click(goToProductButtonSelector);
    }
}
