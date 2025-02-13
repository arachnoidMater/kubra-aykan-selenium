package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtils {
    private static Properties properties;

    static {
        try {
            properties = new Properties();
            FileInputStream file = new FileInputStream("src/test/resources/config.properties");
            properties.load(file);
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("config.properties file could not be loaded!");
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
