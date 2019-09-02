package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author konovalov
 * @since 01.09.2019
 */
public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public static final String URL_HOME = "https://csltd.com.ua";
    public static final String SEARCH_ICON = "//a[@class=\"pure-menu-link squared scope\"]";
    public static final String SEARCH_FIELD = "//*[@id=\"search_form_type_term\"]";

    @FindBy(xpath = SEARCH_ICON)
    private WebElement searchIcon;
    public WebElement getSearchIcon() {
        return searchIcon;
    }

    @FindBy(xpath = SEARCH_FIELD)
    private WebElement searchField;
    public WebElement getSearchField() {
        return searchField;
    }

    public  String getUrlHome() {
        return URL_HOME;
    }
}
