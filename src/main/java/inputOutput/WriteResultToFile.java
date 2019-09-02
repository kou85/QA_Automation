package inputOutput;

import org.openqa.selenium.WebElement;
import java.io.*;
import java.util.List;

/**
 * Запись результатов поиска в файл output.csv
 * @author konovalov
 * @since 01.09.2019
 */
public class WriteResultToFile {

    /**
     * Запись в файл
     * @param headerProduct
     * @param productsList
     * @param headerVacancy
     * @param vacanciesList
     */
    public void output(String headerProduct,List<WebElement> productsList, String headerVacancy, List<WebElement> vacanciesList) {
        try {
            File f = new File(System.getProperty("java.io.tmpdir"));
            File n = new File(f,"output.csv");
            n.createNewFile();
            try (PrintWriter fileWriter = new PrintWriter(new FileOutputStream(n))) {
                for (WebElement webElement : productsList) {
                    if (webElement.getText().equals(""))  continue;
                    fileWriter.write(productsStringBuilder(headerProduct, webElement));
                }
                for (WebElement webElement : vacanciesList) {
                    if (webElement.getText().equals(""))  continue;
                    fileWriter.write(vacanciesStringBuilder(headerVacancy, webElement));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Формирование нужного формата записи строки для раздела "Продукты"
      * @param productHeader
     * @param productList
     * @return String line
     */
    private String productsStringBuilder(String productHeader, WebElement productList) {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(productHeader).append(";").append(productList.getText()).append(";").append(System.lineSeparator());
        return stringBuilder.toString();
    }

    /**
     * Формирование нужного формата записи строки для раздела "Вакансии"
     * @param vacancyHeader
     * @param vacanciesList
     * @return
     */
    private String vacanciesStringBuilder(String vacancyHeader, WebElement vacanciesList) {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(vacancyHeader).append(";").append(vacanciesList.getText()).append(System.lineSeparator());
        return stringBuilder.toString();
    }
}
