import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class Selenium {
    @Test
    void Setup() {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/Resources/chromedriver.exe");

        // Set up ChromeOptions
        ChromeOptions options = new ChromeOptions();
        options.addArguments("*--remote-allow-origins=*");


        // Initialize ChromeDriver with ChromeOptions
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.google.com");

    }
}