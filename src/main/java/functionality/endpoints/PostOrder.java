package functionality.endpoints;

import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;

import static functionality.SetupEnvironment.buildEnv;

public class PostOrder extends EndpointSuper {
    // Empty Constructor
    public PostOrder() {
        System.out.println("In Post Order endpoint");
        requestSpec = buildEnv();
        Auth authentication = new Auth();
        requestSpec.header("Authorization", "Bearer " + authentication.getAccessToken());
        addAdditionalRequestSpecs(requestSpec, constructRequestBody("crusty crust", "flavoursome flavour", "sizeable size", 5));
        postPayload("/api/orders");
    }
    public PostOrder(String crust, String flavor, String size, int TableNumber) {
        System.out.println("In Post Order endpoint");
        requestSpec = buildEnv();
        Auth authentication = new Auth();
        requestSpec.header("Authorization", "Bearer " + authentication.getAccessToken());
        addAdditionalRequestSpecs(requestSpec, constructRequestBody(crust, flavor, size, TableNumber));
        postPayload("/api/orders");
    }
    private static RequestSpecification addAdditionalRequestSpecs(RequestSpecification requestSpec, String requestBody){
        requestSpec.
                body(requestBody);
        return requestSpec;
    }
    @SuppressWarnings("unchecked") // else you get warning in the put's below
    private static String constructRequestBody(String crust, String flavor, String size, int TableNumber){
        JSONObject credentials  = new JSONObject();
        credentials.put("Crust", crust);
        credentials.put("Flavor", flavor);
        credentials.put("Size", size);
        credentials.put("Table_No", TableNumber);
        return credentials.toJSONString();
    }
}
