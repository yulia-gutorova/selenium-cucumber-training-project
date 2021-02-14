Feature: Ajax Form Submit with Loading icon
  Scenario:
    Given I am on the homepage
      |https://www.seleniumeasy.com/test/ajax-form-submit-demo.html|
    When I input "Yulia" in the field Name
    And I input "Comment" in Comment
    And  I click on the "btn-submit" button
    Then I will see a successMessage "Form submited Successfully!"

    Scenario:
      Given I am on the homepage
        |https://www.seleniumeasy.com/test/ajax-form-submit-demo.html|
      When I miss field Name
      And I input "Comment" in Comment
      And  I click on the "btn-submit" button
      Then field Name borders will turn red
      And button "btn-submit" is still visible
