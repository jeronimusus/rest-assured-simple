import functionality.endpoints.Auth;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AuthTest {
    @Test
    public void getAuthTokenHappyPath(){
        Auth authentication = new Auth();
        System.out.println(authentication.getAccessToken());
        authentication.writePayload();
        assertThat(200, equalTo(authentication.getResponse().getStatusCode()));
    }
}
