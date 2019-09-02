package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class SearchPage extends BasePage {

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public static final String PRODUCT_HEADER = "//div[@class='pure-u-xs-1'][1]//h2";
    public static final String PRODUCT_LIST = "//div[@class='pure-u-xs-1'][1]//li";

    public static final String VAKANSII_HEADER = "//div[@class='pure-u-xs-1'][2]//h2";
    public static final String VAKANSII_LIST = "//div[@class='pure-u-xs-1'][2]//li";

    @FindBy(xpath = PRODUCT_HEADER)
    private WebElement productHeader;
    public WebElement getProductHeader() {
        return productHeader;
    }

    @FindBy(xpath = PRODUCT_LIST)
    private List<WebElement> productList;
    public List<WebElement> getProductList() {
        return productList;
    }


    @FindBy(xpath = VAKANSII_HEADER)
    private WebElement vakansiiHeader;
    public WebElement getVakansiiHeader() {
        return vakansiiHeader;
    }

    @FindBy(xpath = VAKANSII_LIST)
    private List<WebElement> vakansiiList;
    public List<WebElement> getVakansiiList() {
        return vakansiiList;
    }
}

