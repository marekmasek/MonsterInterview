package com.project.step;

import com.project.pageObject.MainPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UserAccountStep {

  private static final Logger LOG = LogManager.getLogger(UserAccountStep.class);

  public void createUserAccount() {
    new MainPage().openMainPage().createAccount().fillNewAccountForm();
    LOG.debug("User account was created");
  }
}
