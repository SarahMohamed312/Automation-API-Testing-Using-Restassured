package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class CartPage{

    private WebDriver driver;
    private By placeOrderButton = By.xpath(".//button[text() = 'Place Order']");
    private By addedProduct = By.cssSelector(".success td:nth-of-type(2)");
    private By productPrice = By.cssSelector(".success td:nth-of-type(3)");
    private By deleteItem = By.linkText("Delete");
    private By cartItems = By.className("success");
    private By totalPriceCart = By.id("totalp");
    private WebDriverWait wait;
    private FluentWait fluentWait;
    //WebElement placeOrderForm = driver.findElement(By.className("modal-content"));

    public CartPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.fluentWait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);
    }

    public String getNameOfPlacedOrder(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(addedProduct));
        return driver.findElement(addedProduct).getText();
    }

    public int getNumberOfPlacedOrders(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(cartItems));
        return driver.findElements(cartItems).size();
    }

    public List<String> getListOfPlacedOrders(){
        fluentWait.until(ExpectedConditions.visibilityOfElementLocated(addedProduct));
        List<WebElement> listOfPlacedOrders = driver.findElements(addedProduct);
        return listOfPlacedOrders.stream().map(e->e.getText()).collect(Collectors.toList());
    }

    public String getSumOfProductPrices(){
        fluentWait.until(ExpectedConditions.visibilityOfElementLocated(productPrice));
        List<WebElement> listOfPricesOfPlacedOrders = driver.findElements(productPrice);
        int totalPrices = 0;

        for(WebElement price : listOfPricesOfPlacedOrders){

            totalPrices+=Integer.parseInt(price.getText());
        }
        return String.valueOf(totalPrices);
    }

    public PurchaseModal clickPlaceOrder(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(placeOrderButton));
        driver.findElement(placeOrderButton).click();
        return new PurchaseModal(driver);
    }

    public void clickDeleteItem(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(deleteItem));
        driver.findElement(deleteItem).click();
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(deleteItem)));
    }

    public void deleteAllItemsInCart(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(deleteItem));
        List<WebElement> itemsToDelete = driver.findElements(deleteItem);

        while (!itemsToDelete.isEmpty()) {
            // Click the first delete button and wait for its invisibility
            itemsToDelete.get(0).click();
            wait.until(ExpectedConditions.invisibilityOf(itemsToDelete.get(0)));

            // Refresh the list of items to delete
            itemsToDelete = driver.findElements(deleteItem);
        }
    }

    public boolean isCartEmpty(){
        wait.until(ExpectedConditions.invisibilityOfElementLocated(cartItems));
        return driver.findElements(cartItems).isEmpty();
    }


    public String getTotalPriceInCart(){
        fluentWait.until(ExpectedConditions.visibilityOfElementLocated(totalPriceCart));
        return driver.findElement(totalPriceCart).getText();

    }


    /*
    public String getTotalPriceInCart(){
        fluentWait.until(ExpectedConditions.visibilityOfElementLocated(totalPriceCart));
          String totalPriceText = driver.findElement(totalPriceCart).getText();
          return Integer.parseInt(totalPriceText);
    }

     */
}
