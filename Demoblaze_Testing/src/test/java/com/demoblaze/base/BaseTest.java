package com.demoblaze.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.demblaze.factory.DriverFactory;
public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new DriverFactory().initializeDriver();
    }

    @AfterMethod
    public void teardown() {
        if (driver != null) {
            //driver.quit();
        }
    }
}
