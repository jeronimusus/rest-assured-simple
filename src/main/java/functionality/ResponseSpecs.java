package functionality;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;

import java.util.regex.Pattern;

import static org.hamcrest.text.MatchesPattern.matchesPattern;

public class ResponseSpecs {

    public static ResponseSpecification getCommonResponseSpec(){
        return new ResponseSpecBuilder().
                expectStatusCode(200).
                expectContentType(ContentType.JSON).
                build();
    }
}
