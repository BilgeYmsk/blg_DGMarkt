Feature:The user should be able to bring the products in the price range user want on the Sub-Category Page by using the PRICE slider.


  Scenario Outline:
    Given the user select the "<Category>"
    When  the user selects between 150  and 470 by using the Price slider
    Then  Verify that the user should be able to bring the products in the price range
    Examples:
      | Category        |
      | Health & Beauty |
      | Televisions     |
      | TV Accessories  |
      | Networking      |


