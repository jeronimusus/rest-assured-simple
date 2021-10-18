import functionality.endpoints.GetOrder;
import org.junit.Test;

public class GetOrderTest {
    @Test
    public void pgetAnOrder(){
        GetOrder order = new GetOrder();
        order.writePayload();
    }
}
