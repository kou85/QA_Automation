package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author konovalov
 * @since 01.09.2019
 */
public class GeneralHelper {

    WebDriver driver;

    public GeneralHelper(WebDriver driver) {
        this.driver = driver;
    }

    public static void click(WebElement element) {
        element.click();
    }

    public static void typeToElement(WebElement element, String message) {
        element.sendKeys(message);
    }


}
