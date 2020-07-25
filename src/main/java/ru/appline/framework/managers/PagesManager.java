package ru.appline.framework.managers;

import ru.appline.framework.pages.MainPage;
import ru.appline.framework.pages.ProductPage;
import ru.appline.framework.pages.QueryResultPage;
import ru.appline.model.Product;

public class PagesManager {

    private static PagesManager pagesManager;

    MainPage mainPage;
    QueryResultPage queryResultPage;
    ProductPage productPage;

    private PagesManager() {
    }

    public static PagesManager getPagesManager() {
        if (pagesManager == null) {
            pagesManager = new PagesManager();
        }
        return pagesManager;
    }

    public MainPage getMainPage() {
        if (mainPage == null) {
            mainPage = new MainPage();
        }
        return mainPage;
    }

    public QueryResultPage getQueryResultPage() {
        if (queryResultPage == null) {
            queryResultPage = new QueryResultPage();
        }
        return queryResultPage;
    }

    public ProductPage getProductPage() {
        if (productPage == null) {
            productPage = new ProductPage();
        }
        return productPage;
    }

}
