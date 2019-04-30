package com.advisorwebsite.tools;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageTools {
    private WebDriver driver;
    private static final int WAIT_TIMEOUT = 20;

    protected PageTools(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private WebDriver getDriver() {
        return driver;
    }

    private WebDriverWait getWait() {
        return new WebDriverWait(getDriver(), WAIT_TIMEOUT);
    }

    private WebElement isClickable(WebElement element) {
        return getWait()
                .ignoring(ElementClickInterceptedException.class)
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    private WebElement isVisible(WebElement element) {
        return getWait()
                .ignoring(ElementNotVisibleException.class)
                .until(ExpectedConditions.visibilityOf(element));
    }

    protected void clickOnElement(WebElement element) {
        isClickable(element).click();
    }

    protected void typeText(WebElement element, String text) {
        WebElement el = isVisible(element);
        el.clear();
        el.sendKeys(text);
    }

    protected String getElementText(WebElement element) {
        return isVisible(element).getText();
    }

    protected String getCssValue(WebElement element, String value) {
        return isVisible(element).getCssValue(value);
    }

    protected boolean isElementDisplayed(WebElement element) {
        try {
            return isVisible(element).isDisplayed();
        } catch (NoSuchElementException ex) {
            return false;
        }
    }
}
