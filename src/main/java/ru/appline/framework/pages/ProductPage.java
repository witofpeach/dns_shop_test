package ru.appline.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import ru.appline.model.Product;
import ru.appline.model.ProductList;

import java.util.List;

public class ProductPage extends BasePage {

    @FindBy(xpath = "//h1[@data-product-param='name']")
    WebElement productName;

    @FindBy(xpath = "//span[@data-product-param='code']")
    WebElement productCode;

    @FindBy(xpath = "//span[@class='current-price-value']")
    WebElement productCurrentPrice;

    @FindBy(xpath = "//select[@class='form-control select']")
    WebElement productWarrantySelectionWebElement;

    @FindBy(xpath = "//button[text()='Купить']")
    WebElement buttonAddToCart;

    Product product;

    public ProductPage selectWarrantyOption (String warrantyOption) {
        Select productWarrantySelection = new Select(productWarrantySelectionWebElement);
        productWarrantySelection.selectByVisibleText(warrantyOption);
        if (Long.parseLong(productCurrentPrice.getText().trim().replaceAll(" +", "")) != product.getPrice())
            product.setPriceWithWarranty(Long.parseLong(productCurrentPrice.getText().trim().replaceAll(" +", "")));
        return this;
    }

    public ProductPage saveProduct() {
        checkPresence(productName);
        checkPresence(productCode);
        checkPresence(productCurrentPrice);
        product = new Product(productName.getText(), productCode.getText(), Long.parseLong(productCurrentPrice.getText().trim().replaceAll(" +", "")));
        return this;
    }

    public ProductPage addToCart(ProductList productList) {
        buttonAddToCart.click();
        productList.add(product);
        return this;
    }

}
