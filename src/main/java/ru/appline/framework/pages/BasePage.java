package ru.appline.framework.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.appline.framework.managers.PagesManager;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static ru.appline.framework.managers.DriverManager.getDriver;

public class BasePage {

    protected PagesManager pagesManager = PagesManager.getPagesManager();

    protected Actions action = new Actions(getDriver());

    protected JavascriptExecutor js = (JavascriptExecutor) getDriver();

    protected WebDriverWait wait = new WebDriverWait(getDriver(), 10, 1000);

    public BasePage(){
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(xpath = "//input[@placeholder='Поиск по сайту']")
    WebElement inputSearch;

    @FindBy(xpath = "//span[@class='cart-link__icon']")
    WebElement buttonCart;

    public boolean isElementPresent(WebElement element) {
        try {
            getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
        finally {
            getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }
    }


    public void hover(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        action.moveToElement(element).build().perform();
    }

    public void hoverAndClick(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        action.moveToElement(element).click(element).build().perform();
    }

    public void fillField(WebElement element, String value)  {
        element.clear();
        element.click();
        element.sendKeys(value);
    }

    public void fillFieldAction(WebElement element, String value) {
        action.moveToElement(element).click(element).sendKeys(value).build().perform();
    }

    public boolean checkPresence(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        return true;
    }

    public void click(WebElement element) {
        js.executeScript("arguments[0].scrollIntoView(false);", element);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public QueryResultPage searchProductFromAnyPage(String query) {
        fillField(inputSearch, query);
        action.sendKeys(inputSearch, Keys.ENTER).build().perform();
        return pagesManager.getQueryResultPage();
    }

    public CartPage getToCart() {
        buttonCart.click();
        return pagesManager.getCartPage();
    }

    public void slowClick(WebElement element, int durationInSeconds) {
        wait.until(ExpectedConditions.visibilityOf(element));
        action.moveToElement(element).pause(Duration.ofSeconds(durationInSeconds)).click(element).pause(Duration.ofSeconds(durationInSeconds)).build().perform();
    }
}
