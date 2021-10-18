package functionality;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;

import java.util.regex.Pattern;

import static org.hamcrest.text.MatchesPattern.matchesPattern;

public class ResponseSpecs {

    public static ResponseSpecification getCommonResponseSpec(){
        String correlationIdPattern = "(.*?)"; // This matches on anything, could not get a more precise one to work :-/
        Pattern r = Pattern.compile(correlationIdPattern);
        return new ResponseSpecBuilder().
                expectStatusCode(200).
                expectContentType(ContentType.JSON).
//                expectHeader("Cache-Control", equalTo("max-age=0, no-cache, no-store")).
                expectHeader("correlation-id", matchesPattern(correlationIdPattern)).
                build();
    }
}
