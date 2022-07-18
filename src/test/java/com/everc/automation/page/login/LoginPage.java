package com.everc.automation.page.login;

import com.everc.automation.model.Customer;
import com.everc.automation.page.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends AbstractPage {

    private By closeBannerButton = By.cssSelector("[aria-label='Close Welcome Banner']");
    private By accountNameText = By.cssSelector("[aria-label='Go to user profile'][aria-disabled=false] span");
    private By loginButton =  By.id("loginButton");


    public void getRow(String text) {
        WebElement element = driver.findElement(By.xpath(String.format("//div[contains(text(), '%s')]", text)));
    }

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
        wait = new WebDriverWait(webDriver, Duration.ofSeconds(30));
    }

    @Override public void openPage() {
//
    }

    public void closeBanner() {
        WebElement banner = wait.until(ExpectedConditions.elementToBeClickable(closeBannerButton));
        banner.click();
    }
    public String getUserAccountName() {
        WebElement userAccountName = driver.findElement(accountNameText);
        return userAccountName.getText();
    }

    public void clickOnSubmitButton() {
        WebElement loginSubmitButton = driver.findElement(loginButton);
        loginSubmitButton.click();
    }

    public void enterPassword(String password) {
        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.sendKeys(password);
    }

    public void enterEmail(String username) {
        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.sendKeys(username);
    }

    public void clickOnLoginButton() {
        WebElement loginButton = driver.findElement(By.id("navbarLoginButton"));;
        loginButton.click();
    }

    public void clickOnAccountButton() {
        WebElement accountButton = driver.findElement(By.id("navbarAccount"));
        accountButton.click();
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
