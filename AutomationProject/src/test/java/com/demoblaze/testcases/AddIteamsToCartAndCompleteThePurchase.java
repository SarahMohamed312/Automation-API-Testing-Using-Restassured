package com.demoblaze.testcases;

import com.demoblaze.base.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class AddIteamsToCartAndCompleteThePurchase extends BaseTest {
    @Test(priority = 1)
    public void shouldBeAbleToAddItemsFromPhoneCategory(){
       /* WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
        driver.manage().window().maximize();*/

        //driver.get("https://www.demoblaze.com/");

        driver.findElement(By.xpath("//a[text()='Phones']")).click();
        driver.findElement(By.className("hrefch")).click();
        driver.findElement(By.xpath("//a[text()='Add to cart']")).click();

        //houldBeAbleToAddItemsFromLabtopsCategory

        driver.findElement(By.xpath("//a[text()='Laptops']")).click();
        driver.findElement(By.className("hrefch")).click();
        driver.findElement(By.xpath("//a[text()='Add to cart']")).click();

        //shouldBeAbleToAddItemsFromMonitorsCategory

        driver.findElement(By.xpath("//a[text()='Monitors']")).click();
        driver.findElement(By.xpath("//a[text()='Apple monitor 24']")).click();
        driver.findElement(By.xpath("//a[text()='Add to cart']")).click();

        //CheckCart
        driver.findElement(By.id("cartur")).click();

    }

   /* @Test(priority = 2)
    public void shouldBeAbleToAddItemsFromLabtopsCategory(){

    driver.get("https://www.demoblaze.com/");
    driver.findElement(By.xpath("//a[text()='Laptops']")).click();
    driver.findElement(By.className("hrefch")).click();
    driver.findElement(By.xpath("//a[text()='Add to cart']")).click();
    driver.quit();
    }

    @Test(priority = 3)
    public void shouldBeAbleToAddItemsFromMonitorsCategory(){

    driver.get("https://www.demoblaze.com/");
    driver.findElement(By.xpath("//a[text()='Monitors']")).click();
    driver.findElement(By.xpath("//a[text()='Apple monitor 24']")).click();
    driver.findElement(By.xpath("//a[text()='Add to cart']")).click();
    driver.quit();
    }

    @Test(priority = 4)
    public void CheckCart(){
        // LoginPage loginPage = new LoginPage(driver);

        driver.get("https://www.demoblaze.com/");
        driver.findElement(By.id("cartur")).click();
        //driver.findElement(By.xpath("//a[text()='Delete']")).click();

        driver.quit();

    }

*/
}