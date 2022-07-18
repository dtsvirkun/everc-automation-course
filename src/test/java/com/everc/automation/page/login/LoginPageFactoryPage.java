package com.everc.automation.page.login;

import com.everc.automation.model.Customer;
import com.everc.automation.page.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPageFactoryPage extends AbstractPage {

    // TODO: 18.07.2022  To refactor rest of code to use FindBy's
    @FindBy(css = "[aria-label='Close Welcome Banner']")
    private WebElement closeBannerButton;

    @FindBy(css = "[aria-label='Close Welcome Banner']")
    private WebElement closeBannerButton2;

    @FindBy(css = "[aria-label='Close Welcome Banner']")
    private WebElement closeBannerButton3;



    public LoginPageFactoryPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(driver, this);
    }

    @Override public void openPage() {
//
    }

    public void closeBanner() {
        closeBannerButton.click();
    }

//    public String getUserAccountName() {
////        WebElement userAccountName = driver.findElement(accountNameText);
////        return userAccountName.getText();
//    }

//    public void clickOnSubmitButton() {
////        WebElement loginSubmitButton = driver.findElement(loginButton);
//        loginSubmitButton.click();
//    }

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
//        clickOnSubmitButton();
    }
}
