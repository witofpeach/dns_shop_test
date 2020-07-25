package ru.appline.framework.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class QueryResultPage extends BasePage {

    @FindBy(xpath = "//a[contains(@href, '/product') and @data-role='clamped-link']")
    List<WebElement> products;

    @FindBy(xpath = "//div[@id='catalog-items-page']")
    WebElement queryPage;

    @FindBy(xpath = "//h1[@data-product-param='name']")
    WebElement productName;

    public ProductPage selectProduct(String productNameQuery) {
        if (isElementPresent(queryPage)) {
            for (WebElement product : products) {
                if (product.getText().toLowerCase().contains(productNameQuery.toLowerCase())) {
                    click(product);
                    return pagesManager.getProductPage();
                }
            }
        } else {
            if (productName.getText().toLowerCase().contains(productNameQuery.toLowerCase())) {
                return pagesManager.getProductPage();
            }
        }
        Assert.fail("Product not found");
        return pagesManager.getProductPage();
    }
}
