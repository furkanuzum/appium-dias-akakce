Feature: Search scenarios

Scenario Outline: Search and filter for a product and validate that the final product has "Go to Reseller" button
    Given I am on the home page
    When I click the top search bar
    And I enter "<searchTerm>" into the search bar
    And I select "<category>" category
    And I open filters
    And I filter results by brand "<filterBy>"
    And I click on Ürünleri Gör button
    And I sort results by "<sort>"
    And I click on the <n>th search result item
    Then the product page should be opened with the buy button
    Examples:
      | searchTerm  | category            | filterBy  | sort            | n   |
      | Laptop      | Laptop ve Notebook  | Apple     | En Yüksek Fiyat | 10  |