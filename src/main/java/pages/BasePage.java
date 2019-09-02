package pages;

import org.openqa.selenium.WebDriver;
import static org.openqa.selenium.support.PageFactory.initElements;

public class BasePage {

    private WebDriver driver;
    public BasePage(WebDriver driver) {
        this.driver = driver;
        initElements(driver, this);
    }

}
