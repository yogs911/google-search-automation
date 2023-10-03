# google-search-automation

## Pre-requisites
- *[Java 20](https://openjdk.java.net/projects/jdk/20/)* as the programming language.
- *[Selenium WebDriver](https://www.selenium.dev/)* as the web browser automation framework using the Java binding.
- *[TestNG](https://testng.org/doc/)* as the testing framework.
- *[AssertJ](https://assertj.github.io/doc/)* as the assertion library.
- *[Owner](http://owner.aeonbits.org/)* to minimize the code to handle properties file.
- *[Maven](https://maven.apache.org/)* as the Java build tool.
- *[IntelliJ IDEA](https://www.jetbrains.com/idea/)* as the IDE.

## Project Structure
```
│   .gitignore
│   LICENSE
│   pom.xml
│   README.md
│   starttest.bat
│   starttest.sh
│   
│       
├───src
│   ├───main
│   │   └───java
│   │       └───com
│   │           └───google
│   │               ├───config
│   │               │       ConfigurationManager.java
│   │               │       Configurations.java
│   │               │       
│   │               ├───driver
│   │               │       BrowserFactory.java
│   │               │       DriverManager.java
│   │               │
│   │               ├───pages
│   │               │       BasePage.java
│   │               │       HomePage.java
│   │               │       SearchResultsPage.java
│   │               │
│   │               └───utils
│   │                       Utility.java
│   │
│   └───test
│       └───java
│           └───com
│               └───google
│                   ├───base
│                   │       TestBase.java
│                   │
│                   ├───resources
│                   │   │   test.properties
│                   │   │
│                   │   └───suites
│                   │           testng.xml
│                   │
│                   └───tests
│                           SearchTest.java
│
```

## Run Tests
- Fork the repository
  ```
  git clone https://github.com/yogs911/google-search-automation.git
  ```
- Use one of the below options to run the test
  - Using maven, pass the parameters for '-Dbrowser' to run on desired browser supported browsers - chrome, firefox or edge\
    To run tests in headless mode, pass the parameter -Dheadless=true
  ```
  mvn test -Pweb-execution -Dbrowser=firefox -Dheadless=false
  ```
  - Run the bat file or bash file to run the tests
  ```
  starttest.bat
  ```
   ```
  starttest.sh
  ```
  - Run tests using TestNG, run testng.xml file under src/test/java/com/google/resources/suites
- Configurations are managed using [Owner](http://owner.aeonbits.org/) \
configurations are located in test.properties under src/test/java/com/google/resources
change "search.phrase" property as desired
  ```
  browser=firefox
  url.base=https://www.google.com
  timeout=10
  headless=false
  search.phrase=coffee machine
  ```
  
  
