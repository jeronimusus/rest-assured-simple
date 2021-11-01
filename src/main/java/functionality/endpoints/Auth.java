package functionality.endpoints;

import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;

import static functionality.SetupEnvironment.buildEnv;

public class Auth extends EndpointSuper {
    private String accessToken;
    // Constructor without the required query param
    public Auth() {
        System.out.println("In Auth endpoint to get an access-token");
        requestSpec = buildEnv();
        addAdditionalRequestSpecs(requestSpec, constructRequestBody("test", "test"));
        url = "/api/auth";
        postPayload();
        setAccessToken();
    }
    private static RequestSpecification addAdditionalRequestSpecs(RequestSpecification requestSpec, String requestBody){
        requestSpec.
                body(requestBody);
        return requestSpec;
    }
    @SuppressWarnings("unchecked") // else you get warning in the put's below
    private static String constructRequestBody(String username, String password){
        JSONObject credentials  = new JSONObject();
        credentials.put("password", password);
        credentials.put("username", username);
        return credentials.toJSONString();
    }
    private void setAccessToken(){accessToken = getPayloadJson().get("access_token");}
    public String getAccessToken(){
        return this.accessToken;
    }
}
