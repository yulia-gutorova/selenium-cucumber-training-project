Feature: Handling Prompt Alert (Javascript Alerts)

  Scenario Outline: To click on the OK button of the prompt alert
    Given I am on the Alert box page
      |https://www.seleniumeasy.com/test/javascript-alert-box-demo.html|
    When I click on the Click for Prompt Box
    And I input text "<text>"
    And I click on the OK button
    Then Alert will return text as output "<expectedMessage>"

    Examples:
    |text   |expectedMessage             |
    |Yulia  |You have entered 'My name' !|


