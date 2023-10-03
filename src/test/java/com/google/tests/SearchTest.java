package com.google.tests;

import org.testng.annotations.Test;

import com.google.base.TestBase;
import com.google.pages.HomePage;
import com.google.pages.SearchResultsPage;

import static com.google.config.ConfigurationManager.config;
import static org.assertj.core.api.Assertions.assertThat;

public class SearchTest extends TestBase {

    @Test
    public void searchAndVerifyResults() throws InterruptedException {
        HomePage homePage = new HomePage();
        SearchResultsPage sResultsPage = new SearchResultsPage();

        homePage.search(config().searchPhrase());

        assertThat(sResultsPage.verifySearchResultsDisplayed()).isTrue();

        String resultUrl = sResultsPage.getResultUrl();

        sResultsPage.clickFirstResult();
        assertThat(sResultsPage.getCurrentUrl()).containsIgnoringCase(resultUrl);
        assertThat(sResultsPage.getPageSource()).containsIgnoringCase(config().searchPhrase());

    }
}
