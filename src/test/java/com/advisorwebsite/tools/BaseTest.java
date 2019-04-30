package com.advisorwebsite.tools;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    protected WebDriver driver;

    protected void navigateToUrl(String url) {
        driver.get(url);
    }

    @BeforeClass(alwaysRun = true)
    public void startBrowser() {
        driver = WebDriverFactory.createBrowser();
    }

    @AfterClass(alwaysRun = true)
    public void closeBrowser() {
        driver.quit();
    }
}
