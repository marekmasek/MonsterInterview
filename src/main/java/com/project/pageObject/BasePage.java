package com.project.pageObject;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

import com.codeborne.selenide.SelenideElement;

public class BasePage {

  // header elements
  private final SelenideElement myJobSearchDropdown = $(byXpath("//a[contains(text(),'My Job Search')]"));
  private final SelenideElement savedJobs = $(byXpath("//a[text()='Saved Jobs']"));

  // footer elements
  private final SelenideElement philipsJobsLink = $(byXpath("//a[text()='Philips Jobs']"));

  public void goToPhilipsJobs() {
    philipsJobsLink.scrollTo();
    sleep(1000);
    philipsJobsLink.click();
  }

  public SavedJobsPage goToSavedJobs() {
    myJobSearchDropdown.hover();
    savedJobs.click();
    return new SavedJobsPage();
  }
}
