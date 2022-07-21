package com.everc.automation.framework;

import com.everc.automation.config.TestConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebdriverRunner {

    private static final ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

    private WebdriverRunner() {

    }

    public static WebDriver getWebDriver() {
        if (webDriver.get() == null) {
            if (TestConfig.CONFIG.browser().equals("chrome")) {
                WebDriverManager.chromedriver().setup();
                webDriver.set(new ChromeDriver());
            } else if (TestConfig.CONFIG.browser().equals("firefox")) {
                WebDriverManager.firefoxdriver().setup();
                webDriver.set(new FirefoxDriver());
            } else {
                WebDriverManager.edgedriver().setup();
                webDriver.set(new EdgeDriver());
            }

            webDriver.get().manage().window().maximize();
        }

        return webDriver.get();
    }

    public static void closeWebDriver() {
        if (webDriver.get() != null) {
            webDriver.get().close();
            webDriver.remove();
        }
    }
}
