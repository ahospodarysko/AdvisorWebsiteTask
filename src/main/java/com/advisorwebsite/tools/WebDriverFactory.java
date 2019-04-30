package com.advisorwebsite.tools;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import static org.openqa.selenium.remote.BrowserType.CHROME;
import static org.openqa.selenium.remote.BrowserType.FIREFOX;

class WebDriverFactory {
    //Create factory only with chrome browser
    //Could be more browser here, if needed
    static WebDriver createBrowser() {

        //Set property for browser, default - chrome
        String browser = System.getProperty("browser", "chrome");

        switch (browser) {
            case CHROME:
                WebDriverManager.chromedriver();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--window-size=1920,1080");

                return new ChromeDriver(chromeOptions);
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--window-size=1920,1080");

                return new FirefoxDriver(firefoxOptions);
            default:
                throw new WebDriverException(String.format
                        ("Browser: %s is invalid or not supported by project", browser));
        }
    }
}
