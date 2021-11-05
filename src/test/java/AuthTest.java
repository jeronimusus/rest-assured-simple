import ResponseModels.AuthSuccessResponse;
import functionality.endpoints.Auth;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.matchesPattern;

public class AuthTest {
    @Test
    public void getAuthTokenHappyPath(){
        Auth authentication = new Auth();
        System.out.println(authentication.getAccessToken());
        authentication.writePayload();
        assertThat(200, equalTo(authentication.getResponse().getStatusCode()));
        // Deserialize the response, and check that the access_token value matches the JWT Regex
        AuthSuccessResponse responseBody = authentication.getBody().as(AuthSuccessResponse.class);
        assertThat(responseBody.access_token, matchesPattern("^[A-Za-z0-9-_=]+\\.[A-Za-z0-9-_=]+\\.?[A-Za-z0-9-_.+/=]*$"));
    }
}
