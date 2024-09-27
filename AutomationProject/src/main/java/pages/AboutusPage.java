package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AboutusPage {

    private WebDriver driver;

    public AboutusPage(WebDriver driver) {
            this.driver = driver;
            PageFactory.initElements(driver, this);
        }


    @FindBy(id="example-video_html5_api")
    private WebElement playBtn;

    public void AboutDemoblaze() {

        playBtn.click();
    }
}
