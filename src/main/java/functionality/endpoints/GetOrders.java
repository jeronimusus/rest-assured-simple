package functionality.endpoints;

import functionality.endpoints.EndpointSuper;

import static functionality.SetupEnvironment.buildEnv;

public class GetOrders extends EndpointSuper {
    // Constructor without the required query param
    public GetOrders(boolean doCall) {
        System.out.println("In Get Orders endpoint");
        requestSpec = buildEnv();
        url = "/api/orders";
        if (doCall) {getPayload();}
    }
}
