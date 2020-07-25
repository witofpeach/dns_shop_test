package ru.appline.tests;

import org.junit.jupiter.api.Test;
import ru.appline.model.Product;

import java.util.ArrayList;
import java.util.List;

public class MainTest extends BaseTest {

    @Test
    public void test() throws InterruptedException {

        List<Product> cart = new ArrayList<>();

        pagesManager.getMainPage()
                .searchProduct("playstation")
                .selectProduct("playstation 4 slim black")
                .saveProduct()
                .selectWarrantyOption("2 года")
                .addToCart(cart);

        Thread.sleep(3000);

        cart.forEach(Product::toString);
    }
}
