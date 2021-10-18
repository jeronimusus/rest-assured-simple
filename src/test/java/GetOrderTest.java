import functionality.endpoints.GetOrder;
import org.junit.Test;

public class GetOrderTest {
    @Test
    public void getAnOrder(){
        GetOrder order = new GetOrder();
        order.writePayload();
    }
}
