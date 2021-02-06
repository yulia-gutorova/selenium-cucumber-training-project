# Selenium & Cucumber Training Project

This is a training project to study Selenium and Cucuber for UI testing of [seleniumeasy.com/test/](https://www.seleniumeasy.com/test/) site.

Seleniumeasy.com site contains all possible UI elements such as Input Forms, Date pickers, Table, Progress Bars & Sliders, etc.


## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

* IntelliJ or your preferred IDE
* Java 1.8+
* Maven 3.8.1+
* JUnit 5.7+
* Selenium 3.141+
* Cucumber 6.9.1+

All dependencies are listed in `pom.xml`

### Installing

##### Step 1. Clone this repository to your local machine

##### Step 2. Configuring Selenium

There are two possibilities to configure local browsers - via `Selenium WebDriver` or via a `WebDriverManager`. This repository already contains configuration for WebDriverManager with Chrome browser.

WebDriverManager for Chrome and Firefox can be configured in Java test classes as follows:
```
WebDriverManager.chromedriver().setup();
WebDriverManager.firefoxdriver().setup();
```

If you want to use Selenium WebDriver for testing in your local browsers such as Chrome, Firefox, Edge, Opera, PhantomJS, or Internet Explorer download and install Selenium WebDrivers from [selenium.dev](https://www.selenium.dev/downloads/).

Selenium WebDriver for Chrome and Firefox can be configured in Java test classes as follows:
```
System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
System.setProperty("webdriver.gecko.driver", "/path/to/geckodriver");
``` 
Detailed information how to enable and configure Selenium in IntelliJ can be found here: https://www.jetbrains.com/help/idea/selenium.html.

##### Step 3. Configuring Cucumber

IntelliJ IDEA allows you to work with Cucumber in other languages apart from Java provided that the required plugins are installed and enabled.

Detailed information how to enable and configure Cucumber in IntelliJ can be found here: https://www.jetbrains.com/help/idea/cucumber-support.html.


##### Step 4. Configuring Ranorex Selocity

To auto-generate XPath, link text, RanoreXPath, and CSS selectors for use with Selenium it is recommended to install Chrome plugin [Ranorex Selocity](https://chrome.google.com/webstore/detail/ranorex-selocity/ocgghcnnjekfpbmafindjmijdpopafoe).



## Running the tests

##### Selenium Tests

Selenium tests are stored in package `test/java/selenium_tests`.

Selenium tests in this project don't require any specific actions before start so you can run them by using IntelliJ IDEA as described here: https://www.jetbrains.com/help/idea/performing-tests.html.

##### Cucumber Tests

Cucumber feature files (scenarios) are stored in resources folder `test/resources`.

Cucumber tests are stored in resources folder `test/java/cucumber_steps`.

Cucumber tests in this project don't require any specific actions before start, so you can run them by using IntelliJ IDEA.



## Contributing

This training project assumes that project team members create their individual feature brunches and perform development and update only in own feature brunches.

A main branch is used only for initial state of the project and for the first clone by team members.

