package com.demoblaze.base;

import factory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setup()
    {
        driver =new DriverFactory().intializeDriver();

    }
    @AfterMethod
    public void teardown()
    {

        driver.quit();
    }
}
