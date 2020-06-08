package com.project.general;

import com.project.config.DriverConfig;
import org.testng.annotations.BeforeClass;

public abstract class AbstractTest {

  @BeforeClass
  protected static void setUp() {
    DriverConfig.browserSetUp();
  }
}
