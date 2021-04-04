@Bootstrap
Feature: Bootstrap Modal Windows handling

#Bootstrap Modal Example for Automation
#Single modal example

  Scenario Outline: Single modal example
    Given I am on the Bootstrap Modal Example home page
      |https://www.seleniumeasy.com/test/bootstrap-modal-demo.html|
    When I click on button *Launch modal*
      |//a[@href='#myModal0']|
    And I will see Boots Modal window
    And I click on button in Boots Modal Window "<modalButton>"
    Then Boots Modal Window will close
    Examples:
      |modalButton|
      |.col-md-6.text-left > div:nth-of-type(1) .fade.modal .btn.btn-primary|
      |[class] .row:nth-child(2) .modal-footer .btn:nth-of-type(1)|
      |.col-md-6.text-left > div:nth-of-type(1) .fade.modal .close|

#Click on "Save changes" button
#Click on "Close" button
#Click on X button