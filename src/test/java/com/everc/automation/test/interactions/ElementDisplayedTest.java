package com.everc.automation.test.interactions;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.everc.automation.framework.WebdriverRunner.getWebDriver;

public class ElementDisplayedTest {

    @Test
    public void isDisplayedTest() {
        getWebDriver().get("https://output.jsbin.com/saqoca/2");

        String text = getWebDriver().findElement(By.tagName("body")).getText();
        System.out.println(text);

        //        System.out.println("transparent: " + getWebDriver().findElement(By.id("transparent")).isDisplayed());
        //        System.out.println("white: " + getWebDriver().findElement(By.id("white")).isDisplayed());
        //        System.out.println("behind: " + getWebDriver().findElement(By.id("behind")).isDisplayed());
        //        System.out.println("outside: " + getWebDriver().findElement(By.id("outside")).isDisplayed());
        //        System.out.println("shifted: " + getWebDriver().findElement(By.id("shifted")).isDisplayed());

        getWebDriver().close();
    }

}