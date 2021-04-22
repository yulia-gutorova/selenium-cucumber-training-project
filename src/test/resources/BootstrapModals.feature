@Bootstrap
Feature: Bootstrap Modal Windows handling

#Scenario 1:
#Bootstrap Modal Example for Automation
#Single Modal Example

  Scenario Outline: Single Modal Example
    Given I am on the Bootstrap Modal Example home page
      |https://www.seleniumeasy.com/test/bootstrap-modal-demo.html|
    When I click on *Launch modal* button
      |div:nth-of-type(1) > .col-md-4.text-left > .panel.panel-default > .panel-body > .btn.btn-primary|
    And I will see Single Boots Modal window
    And I click on "<modalButton>" button in Single Boots Modal Window
    Then Single Boots Modal Window should close

#Click on "Save changes" button
#Click on "Close" button
#Click on X button
#in Single Boot Modal Window

    Examples:
      |modalButton|
      |.col-md-6.text-left > div:nth-of-type(1) .fade.modal .btn.btn-primary|
      |[class] .row:nth-child(2) .modal-footer .btn:nth-of-type(1)|
      |.col-md-6.text-left > div:nth-of-type(1) .fade.modal .close|



#Scenario 2:
#Bootstrap Modal Example for Automation
#Multiple Modal Example
#Close Multiple Boots Modal Window

  Scenario Outline: Multiple Modal Example: close modal window
    Given I am on the Bootstrap Modal Example home page
      |https://www.seleniumeasy.com/test/bootstrap-modal-demo.html|
    When I click on *Launch modal* button
      |div:nth-of-type(2) > .col-md-4.text-left > .panel.panel-default > .panel-body > .btn.btn-primary|
    And I will see a Multiple Boots Modal Window
    And I click on "<modalButton>" in Multiple Boots Modal Window
    Then Multiple Boots Modal Window should close

#Click on "Save changes" button
#Click on "Close" button
#Click on X button
#in Single Boot Modal Window

  Examples:
    |modalButton|
    |div#myModal > .modal-dialog  .modal-footer > .btn.btn-primary|
    |#myModal .modal-footer .btn:nth-of-type(1)|
    |div#myModal > .modal-dialog .close|

#Scenario 3:
#Bootstrap Modal Example for Automation
#Multiple Modal Example
#Launch Multiple Boots Modal Window
  Scenario: Multiple Modal Example: launch modal window and close new window
    Given I am on the Bootstrap Modal Example home page
      |https://www.seleniumeasy.com/test/bootstrap-modal-demo.html|
    When I click on *Launch modal* button
      |div:nth-of-type(2) > .col-md-4.text-left > .panel.panel-default > .panel-body > .btn.btn-primary|
    And I click on Launch modal button in the First modal window
      |//a[@href='#myModal2']|
