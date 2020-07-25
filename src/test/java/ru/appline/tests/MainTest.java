package ru.appline.tests;

import org.junit.jupiter.api.Test;
import ru.appline.model.ProductList;


public class MainTest extends BaseTest {

    @Test
    public void test() {

        ProductList cart = new ProductList();

        pagesManager.getMainPage()
                .searchProduct("playstation")
                .selectProduct("playstation 4 slim black")
                .saveProduct()
                .selectWarrantyOption("2 года")
                .addToCart(cart)
                .searchProductFromAnyPage("Detroit")
                .selectProduct("Detroit")
                .saveProduct()
                .addToCart(cart)
                .getToCart()
                .checkTotalPrice(cart)
                .checkWarrantyOption("playstation", 24, cart)
                .checkEachPrice(cart)
                .removeProductFromCart("detroit", cart)
                .checkEachPrice(cart)
                .incrementQuantity("playstation", cart, 2)
                .checkEachPrice(cart)
                .restoreRemovedProductToCart(cart)
                .checkEachPrice(cart);

//        cart.print();

    }
}
