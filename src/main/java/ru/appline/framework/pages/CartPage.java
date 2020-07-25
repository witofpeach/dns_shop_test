package ru.appline.framework.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.appline.model.Product;
import ru.appline.model.ProductList;

import java.util.List;

import static ru.appline.framework.managers.DriverManager.getDriver;

public class CartPage extends BasePage {

    @FindBy(xpath = "//a[@class='cart-items__product-name-link']")
    List<WebElement> productsInCart;

    @FindBy(xpath = "//div[@class='total-amount__label']//span[@class='price__current']")
    WebElement totalPrice;

    @FindBy(xpath = "//span[@class='restore-last-removed']")
    WebElement buttonRestore;

    public CartPage checkTotalPrice(ProductList cart) {
        if (cart.getTotalPrice() != Integer.parseInt(totalPrice.getText().trim().replaceAll(" +", "")))
            Assert.fail("Total prices don't match!");
        return this;
    }

    public CartPage checkWarrantyOption(String name, int warranty, ProductList cart) {
        String fullName = cart.getFullNameByQuery(name);
        try {
            WebElement checkbox = getDriver().findElement(By.xpath("//a[contains(text(), '" + fullName + "')]//..//..//..//..//..//div[@data-commerce-target='basket_additional_warranty_" + warranty + "']//span[contains(@class, 'checked')]"));
            isElementPresent(checkbox);
        } catch (Exception e) {
            Assert.fail("Wrong warranty option!");
        }
        return this;
    }

    public CartPage checkEachPrice(ProductList cart) {
        for (Product product : cart) {
            if (!product.isRemoved()) {
                String name = product.getName();
                long expectedPrice = product.getPrice() * product.getQuantity();
                WebElement currentPriceElement = getDriver().findElement(By.xpath("//a[contains(text(), '" + name + "')]//..//..//..//..//..//span[@class='price__current']"));
                //WebElement currentQuantityElement = getDriver().findElement(By.xpath("//a[contains(text(), '" + name + "')]//..//..//..//..//..//input[@class='count-buttons__input']"));
                long currentPrice = Long.parseLong(currentPriceElement.getText().trim().replaceAll(" +", ""));
                if (expectedPrice == currentPrice) {
                    continue;
                }
                Assert.fail("Wrong price of: " + name + "\n" + expectedPrice + " = " + currentPrice);
            }
        }
        if (!(cart.getTotalPrice() == Long.parseLong(totalPrice.getText().trim().replaceAll(" +", "")))) {
            Assert.fail("Total prices don't match!");
        }
        return this;
    }

    public CartPage removeProductFromCart(String name, ProductList cart) {
        String fullName = cart.getFullNameByQuery(name);
        WebElement buttonRemove = getDriver().findElement(By.xpath("//a[contains(text(), '" + fullName + "')]//..//..//..//..//..//button[text()='Удалить']"));
        slowClick(buttonRemove);
        cart.remove(name);
        return this;
    }

    public CartPage incrementQuantity(String name, ProductList cart, int times){
        String fullName = cart.getFullNameByQuery(name);
        WebElement buttonIncrementQuantity = getDriver().findElement(By.xpath("//a[contains(text(), '" + fullName + "')]//..//..//..//..//..//button[contains(@class, 'count-buttons__button_plus')]"));
        for (int i = 0; i < times; i++) {
            slowClick(buttonIncrementQuantity);
            cart.incrementQuantityByName(name);
        }
        return this;
    }

    public CartPage restoreRemovedProductToCart(ProductList cart) {
        buttonRestore.click();
        for (WebElement productInCart : productsInCart) {
            cart.restoreProduct(productInCart.getText().toLowerCase());
        }
        return this;
    }

}
