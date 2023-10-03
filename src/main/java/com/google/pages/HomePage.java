package com.google.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(name = "q")
    private WebElement searchBox;

    @FindBy(css = "#L2AGLb")
    private WebElement acceptCookiesBtn;

    public void search(String searchPhrase) throws InterruptedException {
        this.acceptCookiesBtn.click();
        this.searchBox.sendKeys(searchPhrase);
        this.searchBox.sendKeys(Keys.ENTER);
    }
}
