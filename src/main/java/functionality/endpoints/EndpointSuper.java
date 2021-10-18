package functionality.endpoints;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.FileWriter;
import java.io.IOException;

import static functionality.ResponseSpecs.getCommonResponseSpec;
import static io.restassured.RestAssured.given;

public class EndpointSuper {
    protected RequestSpecification requestSpec;
    private Response payload = null;
    private JsonPath payloadJson = null;
    private Boolean getCommonResponseSpec = false;
    // Following is used for Swagger validation
//    private static final String AWS_SWAGGER_YAML = "aws_swagger.yaml";
//    private static final String AWS_SWAGGER_YAML = "aws_swagger.json";
//    private static final String AWS_SWAGGER_YAML = "AWS_OPenAPI_3.yaml";
//    private static final OpenApiValidationFilter validationFilter = new OpenApiValidationFilter(AWS_SWAGGER_YAML);;
    public void getPayload(String url){
        requestSpec.log().everything(false);
        payload  = given().
//                      filter(validationFilter).
                        spec(requestSpec).
//                        log().all(). // there are diff kinds of logging available
                    when().
                        get(url); // can't do anymore method chaining as payload needs a Response returned to it
        payloadJson = new JsonPath(payload.asString());
        runCommonResponseSpec();
    }
    public void postPayload(String url){
        payload = given().
//                  filter(validationFilter).
                    spec(requestSpec).
//                    log().all().
                when().
                    post(url); // can't do anymore method chaining as payload needs a Response returned to it
//        payload.then().body(); // Can be used to validate response?
        payloadJson = new JsonPath(payload.asString());
    }
    public JsonPath getPayloadJson (){
        return this.payloadJson;
    }
    public Response getResponse (){
        return this.payload;
    }
    public void setGetCommonResponseSpec(boolean setTo) {getCommonResponseSpec = setTo;}
    private void runCommonResponseSpec() {
        if (getCommonResponseSpec) {
            System.out.println("Verifying Common Response Spec");
            this.payload.then().spec(getCommonResponseSpec()); // validate against common expected response
        }
    }
    public void writePayload() {
        try (FileWriter file = new FileWriter("/Users/tthjvx/Documents/Temp/restAssuredJsons/response_A.json")) {
            file.write(payloadJson.prettyPrint());
            file.flush();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
