package com.project.utils;

import java.util.Random;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UserUtils {

  private static final Logger LOG = LogManager.getLogger(UserUtils.class);

  public static String generateRandomEmailAddress() {
    String emailAddress = ("username" + new Random().nextInt(10000) + "@monstertests.com");
    LOG.debug("Generated email address: [{}]", emailAddress);
    return emailAddress;
  }
}
