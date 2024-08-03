package awesomecucumber.stepdefinitions;

import awesomecucumber.constants.Endpoints;
import awesomecucumber.context.TestContext;
import awesomecucumber.pages.CheckoutPage;
import awesomecucumber.pages.PageFactoryManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class CheckoutStepDefinitions {

    private final TestContext context;

    private final CheckoutPage checkoutPage;

    public CheckoutStepDefinitions(TestContext context) {
        this.context = context;
        checkoutPage = PageFactoryManager.getCheckoutPage(context.driver);
    }

    @When("I provide billing details")
    public void i_provide_billing_details() {
        checkoutPage.setBillingDetails(context.billingDetails);
    }

    @When("I place an order")
    public void i_place_an_order() {
        checkoutPage.placeOrder();
    }

    @Then("the order should be placed successfully")
    public void the_order_should_be_placed_successfully() {
        Assert.assertEquals("Thank you. Your order has been received.", checkoutPage.getNotice());
    }

    @Given("I'm on the Checkout page")
    public void i_m_on_the_checkout_page() {
        checkoutPage.load(Endpoints.CHECKOUT.getEndpoint());
    }
}
