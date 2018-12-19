package Helpers;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {

    static Properties value;

    // return the value for given key
    public static String getProperty(String key) throws IOException {
        if (value == null) {
            value = new Properties();
            File file = new File("src/test/Resources/resources.properties");
            FileInputStream fileInput = new FileInputStream(file);
            value.load(fileInput);
            fileInput.close();
        }

        return value.getProperty(key);
    }

}
