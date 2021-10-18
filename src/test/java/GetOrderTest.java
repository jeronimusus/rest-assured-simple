import functionality.GetOrder;
import org.junit.Test;

public class GetOrderTest {
    @Test
    public void postCheckoutWithRequiredVars(){
        GetOrder order = new GetOrder();
        order.writePayload();
    }
}
