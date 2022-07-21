package com.everc.automation.extention;

import io.qameta.allure.Allure;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import static com.everc.automation.framework.WebdriverRunner.getWebDriver;

@Log4j2
public class TestResultExtension implements TestWatcher, AfterTestExecutionCallback {

    @Override
    public void afterTestExecution(ExtensionContext context) throws IOException {
        if (context.getExecutionException().isPresent()) {
            File screenshot = ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.FILE);
            Allure.addAttachment(screenshot.getName(), new FileInputStream(screenshot));
        }
    }
}
