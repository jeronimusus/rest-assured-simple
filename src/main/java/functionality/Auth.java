package functionality;

import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import static functionality.SetupEnvironment.buildEnv;

public class Auth extends EndpointSuper {
    // Constructor without the required query param
    public Auth() {
        System.out.println("In Auth endpoint to get an access-token");
        requestSpec = buildEnv();
        addAdditionalRequestSpecs(requestSpec, constructRequestBody("test", "test"));
        postPayload("/api/auth");
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
}
