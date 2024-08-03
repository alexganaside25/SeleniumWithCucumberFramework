package awesomecucumber.stepdefinitions;

import awesomecucumber.context.TestContext;
import awesomecucumber.domainobjects.BillingDetails;
import awesomecucumber.pages.PageFactoryManager;
import awesomecucumber.pages.StorePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

import static awesomecucumber.constants.Endpoints.STORE;

public class CustomerStepDefinitions {

    private final TestContext context;

    private final StorePage storePage;

    public CustomerStepDefinitions(TestContext context) {
        this.context = context;
        storePage = PageFactoryManager.getStorePage(context.driver);
    }

    @And("my billing details are")
    public void myBillingDetailsAre(BillingDetails billingDetails) {
        context.billingDetails = billingDetails;
    }

    @Given("I'm a guest customer")
    public void i_m_a_guest_customer() {
        storePage.load(STORE.getEndpoint());
    }
}
