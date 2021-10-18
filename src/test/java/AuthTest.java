import functionality.endpoints.Auth;
import org.junit.Test;
public class AuthTest {
    @Test
    public void getAuthToken(){
        Auth authentication = new Auth();
        System.out.println(authentication.getAccessToken());
        authentication.writePayload();
    }
}
