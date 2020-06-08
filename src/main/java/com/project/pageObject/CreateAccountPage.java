package com.project.pageObject;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.SelenideElement;
import com.project.utils.UserUtils;

public class CreateAccountPage extends BasePage {

  private final SelenideElement emailAddressField = $(byXpath("//input[@id='c_elem_0']"));
  private final SelenideElement passwordField = $(byXpath("//input[@id='a_elem_1']"));
  private final SelenideElement passwordConfirmationField = $(byXpath("//input[@id='a_elem_2']"));
  private final SelenideElement jobCorpsCenterDropdown = $(byXpath("//select[@id='elem_3']"));
  private final SelenideElement termsCheckbox = $(byXpath("//label[@id=\"id_option_label_elem_5-true\"]/span[1]"));
  private final SelenideElement createAnAccountButton = $(byXpath("//button[normalize-space()='Create an account']"));

  public void fillNewAccountForm() {
    emailAddressField.val(UserUtils.generateRandomEmailAddress());
    passwordField.val("Selenide123+");
    passwordConfirmationField.val("Selenide123+");
    jobCorpsCenterDropdown.selectOption(1);
    termsCheckbox.click();
    createAnAccountButton.click();
  }
}
