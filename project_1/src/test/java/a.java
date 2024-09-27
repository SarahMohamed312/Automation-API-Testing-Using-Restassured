
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;


public class a {
  @Test
    void Setup() {
      System.setProperty("Webdriver.egde.driver" , System.getProperty("user.dir") + "/src/test/Resources/msedgedriver.exe");

      WebDriver webDriver = new EdgeDriver();

      webDriver.get("https://www.google.com/");
    }
}