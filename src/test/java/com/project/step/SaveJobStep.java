package com.project.step;

import static java.util.Arrays.asList;

import com.project.pageObject.JobSearchResultsPage;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SaveJobStep {

  private static final Logger LOG = LogManager.getLogger(SaveJobStep.class);

  JobSearchResultsPage jobSearchResultsPage = new JobSearchResultsPage();

  public List<String> saveSecondAndLastPhilipsJobs() {
    LOG.debug("Saving the second and last Philips Jobs");
    return asList(saveNthPhilipsJob(1), saveLastPhilipsJob());
  }

  public String saveNthPhilipsJob(int jobNumber) {
    return jobSearchResultsPage
        .selectNthSearchResult(jobNumber)
        .saveJob()
        .checkJobSavedNotification()
        .getJobName(jobNumber);
  }

  public String saveLastPhilipsJob() {
    return jobSearchResultsPage
        .selectLastSearchResult()
        .saveJob()
        .checkJobSavedNotification()
        .getJobName(jobSearchResultsPage.getNumberOfJobs() - 1);
  }
}
