package com.everc.automation.test;

import com.everc.automation.framework.WebdriverRunner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public class BaseTest {

    protected WebDriver driver;

    @BeforeEach
    public void init() {
        driver = WebdriverRunner.getWebDriver();
        driver.get("https://juice-selenium.herokuapp.com/#/");
        System.out.println("base class setup");
    }

    @AfterEach
    public void tearDown() {
        WebdriverRunner.closeWebDriver();
        System.out.println("after all");
    }
}
