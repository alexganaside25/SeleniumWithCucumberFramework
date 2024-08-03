package awesomecucumber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.nio.charset.StandardCharsets;

public class StorePage extends BasePage {

    @FindBy(xpath = "//a[@class='added_to_cart wc-forward']")
    private WebElement viewCartLink;

    @FindBy(xpath = "//h1[normalize-space()='Store']")
    private WebElement titleText;

    public void addToCart(String productName) {
        String raw = "a[aria-label='Add “" + productName + "” to your cart']";
        byte[] bytes = raw.getBytes(StandardCharsets.UTF_8);
        String utf8Encoded = new String(bytes, StandardCharsets.UTF_8);
        By addToCartButton = By.cssSelector(utf8Encoded);
        wait.until(ExpectedConditions.visibilityOf(titleText));
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(viewCartLink)).click();
    }

    public StorePage(WebDriver driver) {
        super(driver);
    }
}
