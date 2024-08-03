package awesomecucumber.constants;

public enum Endpoints {
    STORE("/store"),
    ACCOUNT("/account"),
    CHECKOUT("/checkout"),
    ADD_TO_CART("/?wc-ajax=add_to_cart");

    private final String endpoint;

    Endpoints(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getEndpoint() {
        return endpoint;
    }
}
