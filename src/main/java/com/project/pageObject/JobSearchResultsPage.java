package com.project.pageObject;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.sleep;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

public class JobSearchResultsPage extends BasePage {

  private final ElementsCollection searchResults = $$(byXpath("//div[@id='SearchResults']/section//h2/a"));
  private final SelenideElement saveJobButton = $(byXpath("//a[@id='SaveJob']"));
  private final SelenideElement jobIsSavedNotification = $(byXpath("//p[text()='Job has been saved to your account.']"));
  private final SelenideElement noMoreResults = $(byXpath("//a[@id='noMoreResults']"));

  public JobSearchResultsPage selectNthSearchResult(int elementIndex) {
    searchResults.get(elementIndex).click();
    return this;
  }

  public JobSearchResultsPage selectLastSearchResult() {
    do {
      searchResults.get(searchResults.size() - 1).scrollIntoView(true);
      sleep(2000);
    } while (!noMoreResults.isDisplayed());

    sleep(1500);
    searchResults.get(searchResults.size() - 1).scrollIntoView(true).click();
    return this;
  }

  public String getJobName(int jobNumber) {
    return searchResults.get(jobNumber).text();
  }

  public int getNumberOfJobs() {
    return searchResults.size();
  }

  public JobSearchResultsPage saveJob() {
    saveJobButton.click();
    return this;
  }

  public JobSearchResultsPage checkJobSavedNotification() {
    jobIsSavedNotification.shouldBe(Condition.visible);
    return this;
  }
}
