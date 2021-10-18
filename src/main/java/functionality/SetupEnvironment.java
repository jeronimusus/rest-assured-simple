package functionality;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.config;
import static io.restassured.config.EncoderConfig.encoderConfig;

public class SetupEnvironment {

    public static RequestSpecification buildEnv() {
        RequestSpecification requestSpec = new RequestSpecBuilder().
                addHeader("Content-Type", "application/json").
                addHeader("Accept", "application/json").
                setBaseUri("https://order-pizza-api.herokuapp.com").
                build();
        // The following config change is needed to stop RestAssured adding UTF info as part of the content-type value in POSTs
        // https://stackoverflow.com/questions/26976624/setting-content-type-in-rest-assured
        // https://github.com/rest-assured/rest-assured/wiki/Usage#avoid-adding-the-charset-to-content-type-header-automatically
        requestSpec.config(config().encoderConfig(encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false)));
        return requestSpec;
    }
}
