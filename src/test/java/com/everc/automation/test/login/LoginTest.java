package com.everc.automation.test.login;

import com.everc.automation.framework.WebdriverRunner;
import com.everc.automation.model.Customer;
import com.everc.automation.page.login.LoginFluentPage;
import com.everc.automation.page.login.LoginPage;
import com.everc.automation.page.login.SignUpPage;
import com.everc.automation.test.BaseTest;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LoginTest extends BaseTest {

    WebDriver driver;

    LoginPage loginPage;
    LoginFluentPage loginFluentPage;
    SignUpPage signUpPage;

    Customer customer;

    @BeforeAll
    public void setup() throws InterruptedException {
        driver = WebdriverRunner.getWebDriver();
        loginPage = new LoginPage(driver);
        loginFluentPage = new LoginFluentPage(driver);
        signUpPage = new SignUpPage(driver);
        driver.get("https://juice-shop.herokuapp.com/");
        loginPage.closeBanner();
        customer = Customer.newBuilder().withPassword("12345678").withName("dima@ukr.net").build();
    }

    @AfterAll
    public void tearDown() {
        driver.close();
    }

    @Test
    public void userCanLoginToApplication() {
        loginPage.loginAs(customer);

        loginPage.clickOnAccountButton();
        String userAccountName = loginPage.getUserAccountName();

        Assertions.assertEquals(customer.getEmail(), userAccountName);

    }

    @Test
    public void userCanLoginToApplicationUsingFluentPage() {
        String userAccountName = loginFluentPage
                .clickOnAccountButton()
                .clickOnLoginButton()
                .enterEmail(customer.getEmail())
                .enterPassword(customer.getPassword())
                .clickOnSubmitButton()
                .getUserAccountName();

        Assertions.assertEquals(customer.getEmail(), userAccountName);

    }

}
