package com.everc.automation.test.login;

import com.codeborne.selenide.AssertionMode;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;

public class SelenideTest {

    @Test
    public void selenideTest() {
        Configuration.timeout = 10;
        Configuration.assertionMode = AssertionMode.SOFT;
        open("https://google.com");
        $x("//div");
        $(By.name("q")).setValue("asdsad");
        $("[name=q]").shouldHave(Condition.visible, Duration.ofSeconds(30));
        Assertions.assertEquals(0,0);
    }
}
