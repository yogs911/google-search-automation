package com.google.driver;

import static com.google.config.ConfigurationManager.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.AbstractDriverOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public enum BrowserFactory {
    CHROME {
        @Override
        public WebDriver createDriverInstance() {
            WebDriverManager.chromedriver().setup();

            return new ChromeDriver(getOptions());
        }

        @Override
        public ChromeOptions getOptions() {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--start-maximized");
            chromeOptions.addArguments("--disable-infobars");
            chromeOptions.addArguments("--disable-notifications");
            chromeOptions.addArguments("--remote-allow-origins=*");

            if (config().headless())
                chromeOptions.addArguments("--headless=new");

            return chromeOptions;
        }
    },
    FIREFOX {
        @Override
        public WebDriver createDriverInstance() {
            WebDriverManager.firefoxdriver().setup();

            return new FirefoxDriver(getOptions());
        }

        @Override
        public FirefoxOptions getOptions() {
            FirefoxOptions firefoxOptions = new FirefoxOptions();

            if (config().headless())
                firefoxOptions.addArguments("--headless");

            return firefoxOptions;
        }
    },
    EDGE {
        @Override
        public WebDriver createDriverInstance() {
            WebDriverManager.edgedriver().setup();

            return new EdgeDriver(getOptions());
        }

        @Override
        public EdgeOptions getOptions() {
            EdgeOptions edgeOptions = new EdgeOptions();
            edgeOptions.addArguments("--start-maximized");

            if (config().headless())
                edgeOptions.addArguments("--headless");

            return edgeOptions;
        }
    };

    /**
     * Used to run local tests where the WebDriverManager will take care of the
     * driver
     *
     * @return a new WebDriver instance based on the browser set
     */
    public abstract WebDriver createDriverInstance();

    /**
     * @return a new AbstractDriverOptions instance based on the browser set
     */
    public abstract AbstractDriverOptions<?> getOptions();

}
