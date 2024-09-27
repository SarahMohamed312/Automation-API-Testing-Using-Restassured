package com.demoblaze.testcases;


import com.demoblaze.base.BaseTest;
//import com.demoblaze.pages.ContactUsPage;
import com.demoblaze.pages.ContactUsPage;
import com.demoblaze.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class EndToEndTest extends BaseTest {

    @Test
    public void endToEndScenario() {
        // Navigate to the website
        driver.get("https://www.demoblaze.com/");

        // Step 1: Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("sarahmohamed", "312"); // Use your actual credentials

        // Step 2: Wait for the login to complete and verify user is logged in
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement welcomeMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nameofuser"))); // Adjust if needed

        Assert.assertTrue(welcomeMessage.getText().contains("sarahmohamed"), "User is not logged in correctly.");

        // Step 3: Open Contact Us page and fill out the form
        ContactUsPage contactUsPage = new ContactUsPage(driver);
        contactUsPage.openContactForm();
        contactUsPage.fillContactForm("sara@gmail.com", "sara", "please help me");
        contactUsPage.sendMessage();

        // Step 4: Verify the success message
        WebElement alertMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.toast-body")));
        String alertText = alertMessage.getText();
        Assert.assertEquals(alertText, "Thanks for your message!", "The alert message is not as expected.");
    }
}
