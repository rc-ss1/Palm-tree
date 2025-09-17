Feature: Add To Cat multiple

  @multiple
  Scenario: Customer Account Login
    When I login with the website and click on All Categories
    Then all categories should display
    When user click on "FlowerShop" category
    Then "FlowerShop" page is display
    When user add product in Cart
    Then product details should display
    When user remove product from cart
    Then success message should display