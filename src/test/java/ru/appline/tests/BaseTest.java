package ru.appline.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import ru.appline.framework.managers.PagesManager;

import static ru.appline.framework.managers.InitManager.*;

public class BaseTest {

    protected PagesManager pagesManager = PagesManager.getPagesManager();

    @BeforeEach
    public void refreshForRepeated() {
        initFramework();
        getBaseUrl();
    }

    @AfterEach
    public void quitForRepeated() {
        quitFramework();
    }

}
