package com.google.pages;

import org.openqa.selenium.support.PageFactory;

import com.google.driver.DriverManager;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.google.config.ConfigurationManager.config;

public abstract class BasePage {

    WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(config().timeout()));
    protected BasePage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }
}
