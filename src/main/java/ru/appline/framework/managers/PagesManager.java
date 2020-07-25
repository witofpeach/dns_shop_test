package ru.appline.framework.managers;

import ru.appline.framework.pages.CartPage;
import ru.appline.framework.pages.MainPage;
import ru.appline.framework.pages.ProductPage;
import ru.appline.framework.pages.QueryResultPage;

public class PagesManager {

    private static PagesManager pagesManager;

    MainPage mainPage;
    QueryResultPage queryResultPage;
    ProductPage productPage;
    CartPage cartPage;

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

    public CartPage getCartPage() {
        if (cartPage == null) {
            cartPage = new CartPage();
        }
        return cartPage;
    }

    public static void nullPagesManeger() {
        pagesManager = null;
    }
}
