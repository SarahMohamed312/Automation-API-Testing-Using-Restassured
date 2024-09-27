package com.demoblaze.testcases;

import com.demoblaze.base.BaseTest;
import com.demoblaze.pages.LoginPage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;


public class LoginTest extends BaseTest {

    @Test
    public void loginWithEmptyUsernameAndEmptyPassword() {
        driver.get("https://www.demoblaze.com/");
        driver.findElement(By.id("login2")).click();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(" ", " ");

        verifyAlertMessage("Please fill out Username and Password.");
    }

    @Test
    public void loginWithCorrectUsernameAndEmptyPassword() {
        driver.get("https://www.demoblaze.com/");
        driver.findElement(By.id("login2")).click();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("sarahmohamed", "");

        verifyAlertMessage("Please fill out Username and Password.");
    }

    @Test
    public void loginWithEmptyUsernameAndCorrectPassword() {
        driver.get("https://www.demoblaze.com/");
        driver.findElement(By.id("login2")).click();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("", "312");

        verifyAlertMessage("Please fill out Username and Password.");
    }

    @Test
    public void shouldBeAbleToLoginWithCorrectUsernameAndPassword() {

        driver.get("https://www.demoblaze.com/");
        driver.findElement(By.id("login2")).click();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("sarahmohamed", "312");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement navbarElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nameofuser")));
        String navbarText = navbarElement.getText();

        Assert.assertTrue(navbarText.contains("Welcome"));
    }

    private void verifyAlertMessage(String expectedMessage) {
        Alert alert = driver.switchTo().alert();
        String alertMessage = alert.getText();
        Assert.assertEquals(alertMessage, expectedMessage);
        alert.accept(); // Close the alert
    }
}
