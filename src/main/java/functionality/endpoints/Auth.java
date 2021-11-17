package functionality.endpoints;

import functionality.interfaces.IRestResponse;
import functionality.interfaces.RestResponse;
import io.restassured.specification.RequestSpecification;
import models.requestModels.AuthRequestBody;
import models.responseModels.AuthSuccessResponse;
import org.json.simple.JSONObject;

import static functionality.SetupEnvironment.buildEnv;

public class Auth extends EndpointSuper {
    private String accessToken;
    private IRestResponse<AuthSuccessResponse> intResponse;
    // Constructor without the required query param
    public Auth() {
        System.out.println("In Auth endpoint to get an access-token");
        requestSpec = buildEnv();
        AuthRequestBody body = new AuthRequestBody("test", "test");
        requestSpec.body(body);
        url = "/api/auth";
        postPayload();
        setAccessToken();
        setPojoResponse();
    }
    private void setAccessToken(){accessToken = getPayloadJson().get("access_token");}
    public String getAccessToken(){
        return this.accessToken;
    }
    private void setPojoResponse(){
        intResponse = new RestResponse<>(AuthSuccessResponse.class, getResponse());
    }
    public IRestResponse<AuthSuccessResponse> getPojoResponse() {return this.intResponse;}
}
