package functionality;

import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;

import static functionality.SetupEnvironment.buildEnv;

public class GetOrder extends EndpointSuper {
    // Constructor without the required query param
    public GetOrder() {
        System.out.println("In Get Order endpoint");
        requestSpec = buildEnv();
        getPayload("/api/orders");
    }

}
