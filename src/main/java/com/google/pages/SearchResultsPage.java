package com.google.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.google.driver.DriverManager;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;

import static com.google.utils.Utility.extractUrl;

public class SearchResultsPage extends BasePage {

    @FindBy(xpath = "//div[@id='rso']/div")
    private WebElement searchResults;

    @FindBy(xpath = "//div[@id='rso']/div[1]")
    private WebElement firstResult;

    @FindBy(xpath = "//div[@id='rso']/div[1]/..//cite[1]")
    private WebElement firstResultUrl;

    public void clickFirstResult() throws InterruptedException {
        this.firstResult.click();
        Thread.sleep(3000);
    }


    public String getPageTitle() {
        return DriverManager.getDriver().getTitle();
    }

    public String getCurrentUrl(){
        return DriverManager.getDriver().getCurrentUrl();
    }

    public Boolean verifySearchResultsDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(searchResults));
        return this.searchResults.isDisplayed();
    }

    public String getResultUrl(){
        return extractUrl(this.firstResultUrl.getText().trim());
    }

    public String getPageSource(){
        return DriverManager.getDriver().getPageSource();
    }

}
