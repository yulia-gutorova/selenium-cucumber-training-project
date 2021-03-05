@Bootstrap
Feature: Bootstrap Modal Windows handling
  Scenario: Single modal example
    Given I am on the Bootstrap Modal Example home page
      |https://www.seleniumeasy.com/test/bootstrap-modal-demo.html|
    When I click on button Launch modal
      |//a[@href='#myModal0']|
    And I will see Boots Modal window
    And I click on button in Boots Modal Window
      |.col-md-6.text-left > div:nth-of-type(1) .fade.modal .btn.btn-primary|
    Then Boots Modal Window will close
