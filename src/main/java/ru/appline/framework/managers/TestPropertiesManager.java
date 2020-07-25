package ru.appline.framework.managers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestPropertiesManager {

    private final Properties properties = new Properties();

    private static TestPropertiesManager INSTANCE = null;

    private TestPropertiesManager() {
        try {
            properties.load(new FileInputStream(
                    new File("src/main/resources/" +
                            System.getProperty("env", "testing") + ".properties")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static TestPropertiesManager getTestPropertiesManager() {
        if (INSTANCE == null) {
            INSTANCE = new TestPropertiesManager();
        }
        return INSTANCE;
    }

    public String getProperty(String key, String defaultValue) {
        return properties.getProperty(key, defaultValue);
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}
