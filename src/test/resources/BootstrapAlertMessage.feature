Feature: Inspect alert dialog boxes


  Scenario Outline: Inspect autocloseable closeable messages
    Given I am on the Bootstrap Alert messages home page
      |https://www.seleniumeasy.com/test/bootstrap-alert-messages-demo.html|
    When I click on button "<button>"
    And  Bootstrap Alert message "<message>" is visible
    And  I wait "<seconds>" seconds
    Then Bootstrap Alert "<message>" will not visible
    And I close driver

    Examples:
      |button                     |message                                                        |seconds|
      |autoclosable-btn-success   |//div[@class='alert alert-success alert-autocloseable-success']| 5     |
      |autoclosable-btn-warning   |//div[@class='alert alert-warning alert-autocloseable-warning']| 3     |
      |autoclosable-btn-danger    |//div[@class='alert alert-danger alert-autocloseable-danger']  | 5     |
      |autoclosable-btn-info      |//div[@class='alert alert-info alert-autocloseable-info']      | 6     |

#  Autocloseable success message
#  Normal success message
#  Autocloseable warning message
#  Normal warning message
#  Autocloseable danger message
#  Normal danger message
#  Autocloseable info message
#  Normal info message

  @BootstrapAlert
 Scenario Outline: Inspect normal messages
    Given I am on the Bootstrap Alert messages home page
      |https://www.seleniumeasy.com/test/bootstrap-alert-messages-demo.html|
    When I click on button "<button>"
    And  Bootstrap Alert message "<message>" is visible
    And  I click on appropriate button "<close>"
    Then Bootstrap Alert "<message>" will not visible
    And I close driver

 Examples:
    |button             |message                                                   |close                                              |
    |normal-btn-success |//div[@class='alert alert-success alert-normal-success']  |.alert.alert-normal-success.alert-success > .close |
    |normal-btn-warning |//div[@class='alert alert-warning alert-normal-warning']  |.alert.alert-normal-warning.alert-warning > .close |
    |normal-btn-danger  |//div[@class='alert alert-danger alert-normal-danger']    |.alert.alert-danger.alert-normal-danger > .close   |
    |normal-btn-info    |//div[@class='alert alert-info alert-normal-info']        |.alert.alert-info.alert-normal-info > .close       |