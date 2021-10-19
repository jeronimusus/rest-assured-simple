import functionality.endpoints.DeleteOrder;
import functionality.endpoints.GetOrder;
import functionality.endpoints.PostOrder;
import org.junit.Test;

public class DeleteOrderTest {
    @Test
    public void deleteAnOrder(){
        // First create an Order to delete
        PostOrder order = new PostOrder("Cheesy", "Curry", "Medium", 5);
        order.writePayload();
        // Now delete the order we just created to keep the DB tidy
        DeleteOrder orderToDelete = new DeleteOrder(String.valueOf(order.getOrderId()));
        orderToDelete.writePayload();
    }
}
