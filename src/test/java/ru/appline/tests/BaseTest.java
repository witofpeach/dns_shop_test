package ru.appline.tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import ru.appline.framework.managers.PagesManager;

import static ru.appline.framework.managers.InitManager.*;

public class BaseTest {

    protected PagesManager pagesManager = PagesManager.getPagesManager();

    @BeforeAll
    public static void setUp() {
        initFramework();
    }

    @BeforeEach
    public void refreshForParam() {
        getBaseUrl();
    }

    @AfterAll
    public static void tearDown() {
        quitFramework();
    }
}
