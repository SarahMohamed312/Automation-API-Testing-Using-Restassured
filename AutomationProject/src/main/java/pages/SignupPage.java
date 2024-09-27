
package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignupPage {
    private WebDriver driver;

    // Constructor
    public SignupPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#sign-username")
    private WebElement username;

    @FindBy(css = "#sign-password")
    private WebElement password; // Fixed the variable name from "passwad" to "password"

    @FindBy(xpath = "//button[text()='Sign up']") // Change this to "Sign up"
    private WebElement signupButton;

    public void signup(String user, String pass) {
        username.sendKeys(user);
        password.sendKeys(pass);
        signupButton.click();
    }
}
