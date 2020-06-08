package com.project.pageObject;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

import com.codeborne.selenide.SelenideElement;

public class MainPage extends BasePage {

  // todo move to .properties file
  private static final String BASE_URL = "https://www.monsterworksdemo.com/home/";

  private final SelenideElement createAcountButton = $(byXpath("//span[text()='CREATE ACCOUNT']"));

  public MainPage openMainPage() {
    open(BASE_URL);
    return this;
  }

  public CreateAccountPage createAccount() {
    createAcountButton.click();
    return new CreateAccountPage();
  }
}
