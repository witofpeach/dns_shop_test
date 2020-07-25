package ru.appline.framework.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.rmi.server.ExportException;
import java.util.List;

import static ru.appline.framework.managers.DriverManager.getDriver;
import static ru.appline.framework.utils.PropertiesConst.*;

public class QueryResultPage extends BasePage {

    @FindBy(xpath = "//a[contains(@href, '/product') and @data-role='clamped-link']")
    List<WebElement> products;

    public ProductPage selectProduct(String productName) {
        for (WebElement product : products) {
            if (product.getText().toLowerCase().contains(productName.toLowerCase())) {
                click(product);
                return pagesManager.getProductPage();
            }
        }
        Assert.fail("product not found");
        return pagesManager.getProductPage();
    }
}
