package com.project.pageObject;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$$;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SavedJobsPage extends BasePage {

  private static final Logger LOG = LogManager.getLogger(SavedJobsPage.class);

  private final ElementsCollection savedJobsList = $$(byXpath("//h2/a"));

  public void assertSavedJobs(List<String> expectedNamesOfSavedJobs) {
    LOG.debug("Check that correct jobs were saved, expected jobs: [{}]", expectedNamesOfSavedJobs);
    savedJobsList.shouldBe(CollectionCondition.textsInAnyOrder(expectedNamesOfSavedJobs));
  }
}
