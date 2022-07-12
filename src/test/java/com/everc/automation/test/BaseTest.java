package com.everc.automation.test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {

    @BeforeAll
    public void init() {
        System.out.println("base class setup");
    }

    @AfterAll
    public void tearDown() {
        System.out.println("after all");
    }
}
