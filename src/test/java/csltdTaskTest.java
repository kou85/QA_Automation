import inputOutput.ReadAndCompareFiles;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import pages.SearchPage;
import inputOutput.WriteResultToFile;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static helpers.GeneralHelper.click;
import static helpers.GeneralHelper.typeToElement;

/**
 * Тест от компании csltd.com.ua
 * Условия работы приложения:
 * 1. Файл выкачки сохраняется в временной папке системы,
 * 2. Туда же нужно добавить файл эталон test.csv в кодировке UTF-8(исходная была в ANSI)
 * 3. Если не знаете где находится временная папка системы, при первом запуске эксепшен напишет адрес места расположения
 * 4. Версия вебдрайвера должна совпадать с установленным у вас Chrome. Здесь используется для версии 76.0.3809.
 * @author konovalov
 * @since 01.09.2019
 */

public class csltdTaskTest {

    WebDriver driver;
    HomePage homePage;
    SearchPage searchPage;
    WriteResultToFile writeResult;
    ReadAndCompareFiles readAndCompareFiles;

    @BeforeEach
    public void beforeMethod() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        homePage = new HomePage(driver);
        searchPage = new SearchPage(driver);
        driver.get(homePage.getUrlHome());
        writeResult = new WriteResultToFile();
        readAndCompareFiles = new ReadAndCompareFiles();
    }

    @Test
    public void fullTest() throws IOException {
        click(homePage.getSearchIcon());
        System.out.println("Clicked on icon search");
        typeToElement(homePage.getSearchField(), "DEVELOPER");
        homePage.getSearchField().sendKeys(Keys.ENTER);
        List<WebElement> listVacancies = searchPage.getVakansiiList();

        String headerVacancy = searchPage.getVakansiiHeader().getText();
        List<WebElement> listProducts = searchPage.getProductList();
        String headerProduct = searchPage.getProductHeader().getText();
        writeResult.output(headerProduct, listProducts, headerVacancy, listVacancies);

        readAndCompareFiles.readFiles(readAndCompareFiles.getPath(), readAndCompareFiles.getList());
        readAndCompareFiles.readFiles(readAndCompareFiles.getPath2(), readAndCompareFiles.getList2());
        readAndCompareFiles.compareFiles();
    }

    @AfterEach
    public void afterMethod() {
        driver.close();
    }
}
