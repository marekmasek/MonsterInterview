package com.project.test;

import static com.codeborne.selenide.AssertionMode.SOFT;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.testng.SoftAsserts;
import com.project.general.AbstractTest;
import com.project.pageObject.BasePage;
import com.project.pageObject.JobSearchResultsPage;
import com.project.step.SaveJobStep;
import com.project.step.UserAccountStep;
import java.util.List;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({SoftAsserts.class})
public class RegisterUserAndSaveJobTest extends AbstractTest {

  @Test
  public static void createAccountAndSaveJobsTest() {
    Configuration.assertionMode = SOFT;
    new UserAccountStep().createUserAccount();
    new BasePage().goToPhilipsJobs();
    List<String> selectedJobs = new SaveJobStep().saveSecondAndLastPhilipsJobs();
    new JobSearchResultsPage().goToSavedJobs().assertSavedJobs(selectedJobs);
  }
}
