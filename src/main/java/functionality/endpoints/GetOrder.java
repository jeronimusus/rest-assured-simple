package functionality.endpoints;

import functionality.endpoints.EndpointSuper;

import static functionality.SetupEnvironment.buildEnv;

public class GetOrder extends EndpointSuper {
    // Constructor without the required query param
    public GetOrder() {
        System.out.println("In Get Order endpoint");
        requestSpec = buildEnv();
        getPayload("/api/orders");
    }
}
