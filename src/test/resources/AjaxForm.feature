@AjaxForm
Feature: Ajax Form Submit with Loading icon
  Scenario:
    #Scenario 1: Submitting the Ajax form with entering name and comment
    Given I am on the homepage
      |https://www.seleniumeasy.com/test/ajax-form-submit-demo.html|
    When I input "Yulia" in the field Name
    And I input "Comment" in Comment
    And  I click on the "btn-submit" button
    Then I will see a successMessage "Form submited Successfully!"
    #And "Yulia" is visible in the Name field and "Comment" is visible in the Comment field

    Scenario:
      #Scenario 2: Submitting the Ajax Form without entering the Name but with entering the Comment
      Given I am on the homepage
        |https://www.seleniumeasy.com/test/ajax-form-submit-demo.html|
      When I miss field Name
      And I input "Comment" in Comment
      And  I click on the "btn-submit" button
      Then field Name borders will turn red
      And button "btn-submit" is still visible
