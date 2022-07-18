package com.everc.automation.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public AbstractPage(WebDriver webDriver) {
        this.driver = webDriver;
    }

    public abstract void openPage();
}
