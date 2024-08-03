package awesomecucumber.stepdefinitions;

import awesomecucumber.context.TestContext;
import awesomecucumber.domainobjects.Product;
import awesomecucumber.pages.CartPage;
import awesomecucumber.pages.PageFactoryManager;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class CartStepDefinitions {

    private final CartPage cartPage;

    public CartStepDefinitions(TestContext context) {
        cartPage = PageFactoryManager.getCartPage(context.driver);
    }

    @Then("I see {int} {product} in the Cart")
    public void i_see_in_the_cart(int quantity, Product product) {
        Assert.assertEquals(product.getName(), cartPage.getProductName());
        Assert.assertEquals(quantity, cartPage.getProductQuantity());
    }
}
