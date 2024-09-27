package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;


public class Categories {
    private WebDriver driver;
    private By phonesCategory = By.xpath("//a[text() = 'Phones']");
    private By laptopsCategory = By.xpath("//a[text() = 'Laptops']");
    private By monitorsCategory = By.xpath("//a[text() = 'Monitors']");
    private By categorySection = By.id("tbodyid");
    private By sectionProducts = By.cssSelector(".card-block");
    //private By itemDiv = By.cssSelector(".col-lg-4.col-md-6.mb-4");
   //private WebDriverWait wait;
    FluentWait fluentWait;



    public Categories(WebDriver driver) {
        this.driver = driver;
     //this.wait = new WebDriverWait(driver,Duration.ofSeconds(7));
        this.fluentWait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(2))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
    }

    public void getListOfPhones() {
        driver.findElement(phonesCategory).click();
    }
    public void getListOfLaptops()  {
        driver.findElement(laptopsCategory).click();
        fluentWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".card-block")));
    }

    public void getListOfMonitors() {
        driver.findElement(monitorsCategory).click();
        fluentWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".card-block")));
        //wait.until(ExpectedConditions.visibilityOfElementLocated(sectionProducts));
        //Thread.sleep(5000);

    }

    public List<WebElement> listCategorySectionProducts(){
        WebElement section = driver.findElement(categorySection);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(sectionProducts));
        return section.findElements(sectionProducts);
    }
}

  /*
        wait.until(ExpectedConditions.);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(sectionProducts));
         */
/*
        FluentWait wait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dummyElement")));

 */

        /*
        new WebDriverWait(driver,Duration.ofSeconds(10))
                .until(webDriver -> ((JavascriptExecutor) webDriver).
                        executeScript("return document.readyState").
                        equals("complete"));
         */


/*
FluentWait wait = new FluentWait(driver)
        .pollingEvery(Duration.ofSeconds(1))
        .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".card-block")));

 */