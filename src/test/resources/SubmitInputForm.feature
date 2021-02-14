Feature: Input form with validation

  Scenario Outline: Submit input form
    Given I'm on the homepage
      |https://www.seleniumeasy.com/test/input-form-demo.html|
    When I input First name as "MyFirstName"
    And I input Last name as "MyLastName"
    And I input E-mail as "somebody@gmail.com"
    And I input Phone as "154343434"
    And I input Address as "Street 5"
    And I input City as "MyCity"
    And I choose state
          |Alaska|
    And I input Zip code as "111 11"
    And I input Website as
          |https://www.seleniumeasy.com|
    And I choose hosting "<radioButton>"
    And I write projects description as "This is a training project"
    And I click on the button Send
    Then I will see that all the fields have default values


    Examples:
      |radioButton|
      |//input[@value='yes']|
      |//input[@value='no'] |


