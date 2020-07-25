package ru.appline.framework.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {

    @FindBy(xpath = "//input[@name='q' and @placeholder='Поиск по сайту']")
    WebElement inputQuery;

    public QueryResultPage searchProduct(String query) {
        fillField(inputQuery, query);
        action.sendKeys(inputQuery, Keys.ENTER).build().perform();
        return pagesManager.getQueryResultPage();
    }
}
