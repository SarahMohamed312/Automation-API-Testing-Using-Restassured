package com.demoblaze.testcases;

import com.demoblaze.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.AboutusPage;

import java.time.Duration;

public class AboutusTest extends BaseTest {
    @Test
    public void ShowInformationAboutSite() {
        //WebDriverManager.chromedriver().setup();
        //WebDriver driver = new ChromeDriver();
        //JavascriptExecutor js = (JavascriptExecutor) driver;

        try {
            // Set implicit wait
            //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
            //driver.manage().window().maximize();
           // driver.get("https://www.demoblaze.com/");

            // Click on 'About us' link by text
            driver.findElement(By.xpath("//a[text()='About us']")).click();
            //driver.findElement(By.cssSelector("div.vjs-poster")).click();
            //  JavaScript
            //WebElement videoElement = driver.findElement(By.cssSelector("div.vjs-poster"));
            //js.executeScript("arguments[0].pause();", videoElement);
            //driver.findElement(By.xpath("//button[@data-dismiss=\"modal\"]")).click();
            //driver.findElement(By.xpath("//span[@aria-hidden=\"true\"]")).click();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            AboutusPage aboutusPage=new AboutusPage(driver);
            aboutusPage.AboutDemoblaze();
            //wait.until(ExpectedConditions.elementToBeClickable(By.className("btn btn-secondary")));

        }
        catch (Exception e) {
            System.out.println("**************************");
            System.out.println("Errooooooooooooooooooor  "+ e.getMessage());
            System.out.println("**************************");
        }
        finally {

            driver.quit();
        }
    }
}
