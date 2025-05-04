package com.akakce.stepdef;

import com.akakce.pages.FilterPage;
import com.akakce.pages.HomePage;
import com.akakce.pages.LoginPage;
import com.akakce.pages.ProductPage;
import com.akakce.pages.SearchPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchSteps {
    private HomePage homePage = new HomePage();
    private SearchPage searchPage = new SearchPage();
    private FilterPage filterPage = new FilterPage();
    private LoginPage loginPage = new LoginPage();
    private ProductPage productPage = new ProductPage();

    @Given("I am on the home page")
    public void iAmOnTheHomePage() {
        homePage.dismissNotificationPopupIfPresent();
        if (loginPage.isOpened()) {
            loginPage.clickSkipRegisterButton();
        }
        homePage.clickOnHomePageIcon();
    }

    @When("I click the top search bar")
    public void iClickTheTopSearchBar() {
        homePage.clickOnTopSearchBar();
    }

    @When("I enter {string} into the search bar")
    public void iSearchFor(String searchTerm) throws Exception {
        searchPage.enterSearchTerm(searchTerm);
    }

    @When("I select {string} category")
    public void iSelectCategory(String categoryName) throws Exception {
        searchPage.clickOnCategory(categoryName);
    }

    @When("I open filters")
    public void iOpenFilters() throws Exception {
        searchPage.clickOnFilter();
    }

    @When("I filter results by brand {string}")
    public void iFilterByBrand(String brandName) throws Exception {
        filterPage.filterByBrand(brandName);
    }

    @When("I click on Ürünleri Gör button")
    public void iclickOnSeeProductsButton() throws Exception {
        filterPage.applyFilters();
    }

    @When("I sort results by {string}")
    public void iSortResultsBy(String sortName) throws Exception {
        searchPage.sortBy(sortName);
    }

    @When("I click on the {int}th search result item")
    public void iClickOnNthSearchResult(Integer n) throws Exception {
        searchPage.selectAndClickNthSearchItem(n);
    }

    @Then("the product page should be opened with the buy button")
    public void theProductPageIsOpenedWithTheBuyButton() throws Exception {
        productPage.isOpened();
    }
}
