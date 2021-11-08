package functionality.endpoints;

import io.restassured.specification.RequestSpecification;
import models.requestModels.AuthRequestBody;
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
    private static RequestSpecification addAdditionalRequestSpecs(RequestSpecification requestSpec, AuthRequestBody requestBody){
        requestSpec.
                body(requestBody);
        return requestSpec;
    }
    private static AuthRequestBody constructRequestBody(String username, String password){
        AuthRequestBody body = new AuthRequestBody(password, username);
        return body;
    }
    private void setAccessToken(){accessToken = getPayloadJson().get("access_token");}
    public String getAccessToken(){
        return this.accessToken;
    }
}
