package com.everc.automation.page.login;

import com.everc.automation.model.Customer;
import com.everc.automation.page.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginFluentPage extends AbstractPage {

    private By closeBannerButton = By.cssSelector("[aria-label='Close Welcome Banner']");
    private By accountNameText = By.cssSelector("[aria-label='Go to user profile'][aria-disabled=false] span");
    private By loginButton =  By.id("loginButton");


    public void getRow(String text) {
        WebElement element = driver.findElement(By.xpath(String.format("//div[contains(text(), '%s')]", text)));
    }

    public LoginFluentPage(WebDriver webDriver) {
        super(webDriver);
        wait = new WebDriverWait(webDriver, Duration.ofSeconds(30));
    }

    @Override public void openPage() {
//
    }

    public SignUpPage clickOnSignUpButton() {
        WebElement banner = wait.until(ExpectedConditions.elementToBeClickable(closeBannerButton));
        banner.click();
        return new SignUpPage(driver);
    }

    public LoginFluentPage closeBanner() {
        WebElement banner = wait.until(ExpectedConditions.elementToBeClickable(closeBannerButton));
        banner.click();
        return this;
    }

    public String getUserAccountName(String textExpected) {
        wait.until(ExpectedConditions.textToBePresentInElementLocated(accountNameText, textExpected));
        WebElement userAccountName = driver.findElement(accountNameText);
        return userAccountName.getText();
    }

    public LoginFluentPage clickOnSubmitButton() {
        WebElement loginSubmitButton = driver.findElement(loginButton);
        loginSubmitButton.click();
        return this;
    }

    public LoginFluentPage enterPassword(String password) {
        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.sendKeys(password);
        return this;
    }

    public LoginFluentPage enterEmail(String username) {
        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.sendKeys(username);
        return this;
    }

    public LoginFluentPage clickOnLoginButton() {
        WebElement loginButton = driver.findElement(By.id("navbarLoginButton"));;
        loginButton.click();
        return this;
    }

    public LoginFluentPage clickOnAccountButton() {
        WebElement accountButton = driver.findElement(By.id("navbarAccount"));
        accountButton.click();
        return this;
    }

    public void loginAs(Customer customer) {
        clickOnAccountButton();
        clickOnLoginButton();
        enterEmail(customer.getEmail());
        enterPassword(customer.getPassword());
//        eneterUserName(customer.getUserName());
        clickOnSubmitButton();
    }
}
