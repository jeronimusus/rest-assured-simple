import functionality.endpoints.DeleteOrder;
import functionality.endpoints.GetOrder;
import org.junit.Test;

public class DeleteOrderTest {
    @Test
    public void deleteAnOrder(){
        DeleteOrder order = new DeleteOrder("4");
        order.writePayload();
    }
}
