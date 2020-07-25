package ru.appline.framework.managers;

import java.util.concurrent.TimeUnit;

import static ru.appline.framework.managers.DriverManager.getDriver;
import static ru.appline.framework.managers.DriverManager.quitDriver;
import static ru.appline.framework.utils.PropertiesConst.*;

public class InitManager {

    public static TestPropertiesManager properties = TestPropertiesManager.getTestPropertiesManager();

    public static void initFramework() {
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(Integer.parseInt(properties.getProperty(IMPLICITLY_WAIT)), TimeUnit.SECONDS);
        getDriver().manage().timeouts().pageLoadTimeout(Integer.parseInt(properties.getProperty(PAGE_LOAD_TIMEOUT)), TimeUnit.SECONDS);
        getDriver().get(properties.getProperty(APP_URL));
    }

    public static void getBaseUrl() {
        getDriver().get(properties.getProperty(APP_URL));
    }

    public static void quitFramework() {
        quitDriver();
    }
}
