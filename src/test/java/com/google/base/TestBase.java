package com.google.base;

import static com.google.config.ConfigurationManager.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.google.driver.BrowserFactory;
import com.google.driver.DriverManager;

public abstract class TestBase {

    @BeforeMethod(alwaysRun = true)
    @Parameters({"browser"})
    public void setUp(@Optional("chrome") String browser) {
        System.out.println(BrowserFactory.valueOf(browser.toUpperCase()));
        WebDriver driver = BrowserFactory.valueOf(browser.toUpperCase()).createDriverInstance();
        DriverManager.setDriver(driver);
        DriverManager.getDriver().manage().window().maximize();
        DriverManager.getDriver().get(config().url());
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        DriverManager.quit();
    }

}
