package awesomecucumber.pages;

import awesomecucumber.domainobjects.BillingDetails;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends BasePage {

    @FindBy(id = "billing_first_name")
    private WebElement billingFirstNameField;

    @FindBy(id = "billing_last_name")
    private WebElement billingLastNameField;

    @FindBy(id = "billing_address_1")
    private WebElement billingAddressOneField;

    @FindBy(id = "billing_city")
    private WebElement billingCityField;

    @FindBy(id = "billing_state")
    private WebElement billingStateDropDown;

    @FindBy(id = "select2-billing_state-container")
    private WebElement alternateBillingStateDropDown;

    @FindBy(id = "billing_postcode")
    private WebElement billingZipField;

    @FindBy(id = "billing_email")
    private WebElement billingEmailField;

    @FindBy(id = "place_order")
    private WebElement placeOrderButton;

    @FindBy(css = ".woocommerce-notice")
    private WebElement noticeText;

    private final By overlay = By.cssSelector(".blockUI.blockOverlay");

    public CheckoutPage enterBillingFirstName(String billingFirstName) {
        WebElement e = wait.until(ExpectedConditions.visibilityOf(billingFirstNameField));
        e.clear();
        e.sendKeys(billingFirstName);
        return this;
    }

    public CheckoutPage enterBillingLastName(String billingLastName) {
        WebElement e = wait.until(ExpectedConditions.visibilityOf(billingLastNameField));
        e.clear();
        e.sendKeys(billingLastName);
        return this;
    }

    public CheckoutPage enterBillingAddressLineOne(String billingAddressLineOne) {
        WebElement e = wait.until(ExpectedConditions.visibilityOf(billingAddressOneField));
        e.clear();
        e.sendKeys(billingAddressLineOne);
        return this;
    }

    public CheckoutPage enterBillingCity(String billingCity) {
        WebElement e = wait.until(ExpectedConditions.visibilityOf(billingCityField));
        e.clear();
        e.sendKeys(billingCity);
        return this;
    }

    public CheckoutPage selectBillingState(String billingStateName) {
        wait.until(ExpectedConditions.elementToBeClickable(alternateBillingStateDropDown)).click();
        WebElement e = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[text()='" + billingStateName +"']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", e);
        e.click();

//        Select select = new Select(wait.until(ExpectedConditions.visibilityOf(billingStateDropDown)));
//        select.selectByVisibleText(billingStateName);
        return this;
    }

    public CheckoutPage enterBillingZip(String billingZip) {
        WebElement e = wait.until(ExpectedConditions.visibilityOf(billingZipField));
        e.clear();
        e.sendKeys(billingZip);
        return this;
    }

    public CheckoutPage enterBillingEmail(String billingEmail) {
        WebElement e = wait.until(ExpectedConditions.visibilityOf(billingEmailField));
        e.clear();
        e.sendKeys(billingEmail);
        return this;
    }

    //builder pattern
    public CheckoutPage setBillingDetails(BillingDetails billingDetails) {
        return enterBillingFirstName(billingDetails.getBillingFirstName())
                .enterBillingLastName(billingDetails.getBillingLastName())
                .enterBillingAddressLineOne(billingDetails.getBillingAddressOne())
                .enterBillingCity(billingDetails.getBillingCity())
                .selectBillingState(billingDetails.getBillingStateName())
                .enterBillingZip(billingDetails.getBillingZip())
                .enterBillingEmail(billingDetails.getBillingEmail());
    }

    public CheckoutPage placeOrder() {
        waitForOverlaysToDisappear(overlay);
        wait.until(ExpectedConditions.elementToBeClickable(placeOrderButton)).click();
        return this;
    }

    public String getNotice() {
        return wait.until(ExpectedConditions.visibilityOf(noticeText)).getText();
    }

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }
}
