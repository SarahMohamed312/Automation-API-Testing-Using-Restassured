package com.demoblaze.pages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactUsPage {
    private WebDriver driver;

    // Locators
    private By contactLink = By.cssSelector("a.nav-link[data-target='#exampleModal']");
    private By emailField = By.id("recipient-email");
    private By nameField = By.id("recipient-name");
    private By messageField = By.id("message-text");
    private By sendButton = By.cssSelector("button.btn.btn-primary");

    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openContactForm() {
        driver.findElement(contactLink).click();
    }

    public void fillContactForm(String email, String name, String message) {
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(messageField).sendKeys(message);
    }

    public void sendMessage() {
        driver.findElement(sendButton).click();
    }
}
