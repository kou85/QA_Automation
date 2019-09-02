package inputOutput;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Чтение и сравнение файлов test.csv и output.csv
 * !!!Lля правильной работы файлы должны иметь кодировку UTF-8
 * @author konovalov
 * @since 01.09.2019
 */
public class ReadAndCompareFiles {

    private String path = "test.csv";
    private String path2 = "output.csv";
    private List<String> list = new ArrayList<>();
    private List<String> list2 = new ArrayList<>();

    /**
     * Чтение файлов и запись в листы
     * @param path file name
     * @param listCompare Array list
     */
    public void readFiles(String path, List<String> listCompare) {
        File f = new File(System.getProperty("java.io.tmpdir") + File.separator + path);
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
           while (br.ready()) {
               StringBuilder stringBuilder = new StringBuilder();
               stringBuilder.append(br.readLine());
               listCompare.add(stringBuilder.toString());
           }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Сравнение файлов посимвольно
     */
    public void compareFiles() {
        for (String v : list2) {
            for (String v1 : list) {
                if (v.equals(v1)) {

                    System.out.println("Duplicate recording: " + v);
                }
            }
        }
    }

    public String getPath() {
        return path;
    }

    public String getPath2() {
        return path2;
    }

    public List<String> getList() {
        return list;
    }

    public List<String> getList2() {
        return list2;
    }
}
