package com.project.config;

import com.codeborne.selenide.Configuration;

public class DriverConfig {

  public static void browserSetUp() {
    System.setProperty("selenide.browser", "chrome");
    Configuration.timeout = 20000;
    Configuration.startMaximized = true;
  }
}
