import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniumClass {
   private void Setup(){
        ChromeOptions options= new ChromeOptions();
        options.addArguments("-----");
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.google.com/");

    }
}
