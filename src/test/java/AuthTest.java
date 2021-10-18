import functionality.Auth;
import org.junit.Test;
public class AuthTest {
    @Test
    public void postCheckoutWithRequiredVars(){
        Auth authentication = new Auth();
        authentication.writePayload();
    }
}
