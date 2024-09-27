package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
   private WebDriver driver;

    //create constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
       PageFactory.initElements(driver, this);
    }


    @FindBy(id = "loginusername")
    private WebElement username;

    @FindBy(id = "loginpassword")
    private WebElement passwad;

    @FindBy(xpath = "//button[text()='Log in']")
    private WebElement butn;

    public void loginToDemoblaze(String user, String pass) {
        username.sendKeys(user);
        passwad.sendKeys(pass);
        butn.click();
      }
}

