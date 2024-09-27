package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;


public class DriverFactory {

    public WebDriver intializeDriver()
    {
        WebDriver driver;
        String mybrowser = System.getProperty("mybrowser","CHROME");//default value="CHROME"
        switch (mybrowser){
            case "CHROME":
                driver=new ChromeDriver();
                break;
            case "FIREFOX":
                driver=new FirefoxDriver();
                break;
            case "SAFARI":
                driver=new SafariDriver();
            default:
                throw new RuntimeException("The browser is not supported");

           }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        driver.get("https://www.demoblaze.com/");


        return driver;
    }
}
