package com.everc.automation.test.login;

import com.everc.automation.framework.WebdriverRunner;
import com.everc.automation.test.BaseTest;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LoginTest extends BaseTest {

    String userName = "dima@ukr.net";
    String password = "12345678";
    WebDriver driver;

    @BeforeAll
    public void setup() {
        driver = WebdriverRunner.getWebDriver();
        driver.get("https://juice-shop.herokuapp.com/");
        driver.findElement(By.cssSelector("[aria-label='Close Welcome Banner']")).click();
    }

    @AfterAll
    public void tearDown() {
        driver.close();
    }

    @Test
    public void userCanLoginToApplication() {

        WebElement accountButton = driver.findElement(By.id("navbarAccount"));
        accountButton.click();

        WebElement loginButton = driver.findElement(By.id("navbarLoginButton"));
        loginButton.click();

        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.sendKeys(userName);

        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.sendKeys(password);

        WebElement loginSubmitButton = driver.findElement(By.id("loginButton"));
        loginSubmitButton.click();

        accountButton = driver.findElement(By.id("navbarAccount"));
        accountButton.click();

        WebElement userAccountName = driver.findElement(By.cssSelector("[aria-label='Go to user profile'][aria-disabled=false] span"));

        Assertions.assertEquals(userName, userAccountName.getText());

    }
}
