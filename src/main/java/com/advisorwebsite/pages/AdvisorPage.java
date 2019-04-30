package com.advisorwebsite.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;

public class AdvisorPage extends BasePage {

    @FindBy(xpath = "//input[@id='edit-name']")
    private WebElement emailInputField;

    @FindBy(xpath = "//input[@id='edit-pass']")
    private WebElement passwordInputField;

    @FindBy(xpath = "//input[@value='Log in']")
    private WebElement loginButton;

    @FindBy(xpath = "//a[@id='edit-forgot']")
    private WebElement forgotPasswordLink;

    @FindBy(xpath = "//input[@id='edit-submit']")
    private WebElement submitButton;

    @FindBy(xpath = "//input[@id='edit-name' and contains(@class, 'error')]")
    private WebElement errorEmailInputField;

    @FindBy(xpath = "//div[@class='form-item--error-message']")
    private WebElement formErrorMessage;

    @FindBy(xpath = "//li[contains(@class, 'error')]")
    private WebElement alertErrorMessage;

    public AdvisorPage(WebDriver driver) {
        super(driver);
    }

    public void typeEmail(String email) {
        typeText(emailInputField, email);
    }

    public void typePassword(String password) {
        typeText(passwordInputField, password);
    }

    public void clickLoginButton() {
        clickOnElement(loginButton);
    }

    public void clickForgotPasswordLink() {
        clickOnElement(forgotPasswordLink);
    }

    public void clickSubmitButton() {
        clickOnElement(submitButton);
    }

    public String getAlertErrorMessage() {
        return getElementText(alertErrorMessage);
    }

    public String getFormErrorMessage() {
        return getElementText(formErrorMessage);
    }

    public String getAlertBoxColor() {
        return Color.fromString(getCssValue(alertErrorMessage, "background-color")).asHex();
    }

    public String getEmailBoxBorderColor() {
        return Color.fromString(getCssValue(emailInputField, "border-color")).asHex();
    }

    public boolean isErrorEmailBoxDisplayed() {
        return isElementDisplayed(errorEmailInputField);
    }
}
