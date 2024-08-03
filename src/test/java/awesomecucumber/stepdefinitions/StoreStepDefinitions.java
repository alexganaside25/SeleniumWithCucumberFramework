package awesomecucumber.stepdefinitions;

import awesomecucumber.apis.CartApi;
import awesomecucumber.context.TestContext;
import awesomecucumber.domainobjects.Product;
import awesomecucumber.pages.PageFactoryManager;
import awesomecucumber.pages.StorePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import static awesomecucumber.constants.Endpoints.STORE;

public class StoreStepDefinitions {

    private final StorePage storePage;

    private final TestContext context;

    public StoreStepDefinitions(TestContext context) {
        this.context = context;
        storePage = PageFactoryManager.getStorePage(context.driver);
    }

    @Given("I'm on the Store page")
    public void i_m_on_the_store_page() {
        storePage.load(STORE.getEndpoint());
    }

    @When("I add a {product} to the Cart")
    public void i_add_a_to_the_cart(Product product) {
        storePage.addToCart(product.getName());
    }

    @Given("I have a product in the cart")
    public void i_have_a_product_in_the_cart() {
//        storePage.addToCart("Blue Shoes");
        CartApi cartApi = new CartApi(context.cookies.getCookies());
        cartApi.addToCart(1215, 1);
        context.cookies.setCookies(cartApi.getCookies());   //needed for further api calls
        context.cookies.injectCookiesToBrowser(context.driver);
    }
}
