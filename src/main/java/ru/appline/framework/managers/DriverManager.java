package ru.appline.framework.managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static ru.appline.framework.utils.PropertiesConst.*;

public class DriverManager {

    private static WebDriver driver;
    private static TestPropertiesManager properties = TestPropertiesManager.getTestPropertiesManager();

    private DriverManager() {
    }

    private static void initDriver() {
        switch (properties.getProperty(TYPE_BROWSER)) {
            case "firefox":
                System.setProperty("webdriver.gecko.driver", properties.getProperty(PATH_GEKO_DRIVER));
                driver = new FirefoxDriver();
                break;
            default:
                System.setProperty("webdriver.chrome.driver", properties.getProperty(PATH_CHROME_DRIVER));
                driver = new ChromeDriver();
        }
    }


    public static WebDriver getDriver() {
        if (driver == null) {
            initDriver();
        }
        return driver;
    }

    public static void quitDriver() {
        driver.quit();
        driver = null;
    }
}
