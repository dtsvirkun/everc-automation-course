package com.everc.automation.test.login;

import com.everc.automation.model.Customer;
import com.everc.automation.model.Product;
import com.everc.automation.page.login.LoginFluentPage;
import com.everc.automation.page.login.LoginPage;
import com.everc.automation.page.login.SignUpPage;
import com.everc.automation.test.BaseTest;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

@Execution(ExecutionMode.CONCURRENT)
@TestInstance(TestInstance.Lifecycle.PER_METHOD)
@Epic("Login/Logout")
@Story("User able to login")
@Feature("Login")
public class LoginTest extends BaseTest {


    LoginPage loginPage;
    LoginFluentPage loginFluentPage;
    SignUpPage signUpPage;

    Customer customer;

    @BeforeEach
    public void setup() {
        loginPage = new LoginPage(driver);
        loginFluentPage = new LoginFluentPage(driver);
        signUpPage = new SignUpPage(driver);
        loginPage.closeBanner();
        customer = Customer.newBuilder().withPassword("12345678").withName("dima@ukr.net").build();
    }

    @Test
    @Tag("smoke")
    public void userCanLoginToApplication() {
        loginPage.loginAs(customer);

        loginPage.clickOnAccountButton();
        String userAccountName = loginPage.getUserAccountName(customer.getEmail());

        Assertions.assertEquals(customer.getEmail(), userAccountName);

    }

    @Test
    @Link("http://tcnumber")
    @Issue("MERV-1234")
    public void userCanLoginToApplicationUsingFluentPage() {
        String userAccountName = loginFluentPage
                .clickOnAccountButton()
                .clickOnLoginButton()
                .enterEmail(customer.getEmail())
                .enterPassword(customer.getPassword())
                .clickOnSubmitButton()
                .clickOnAccountButton()
                .getUserAccountName(customer.getEmail());

//        Product product = Product.builder().productName("juice").productPrice(45.0).build();
//        product.setProductName("Juice");


        Assertions.assertEquals(customer.getEmail(), userAccountName);
    }

}
