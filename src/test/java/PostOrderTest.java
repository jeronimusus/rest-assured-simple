import functionality.endpoints.DeleteOrder;
import functionality.endpoints.GetOrder;
import functionality.endpoints.PostOrder;
import org.junit.Test;

public class PostOrderTest {
    @Test
    public void postAnOrderWithNoDetails(){
        PostOrder order = new PostOrder();
        order.writePayload();
        System.out.println(order.getCrust());
        System.out.println(order.getFlavor());
        System.out.println(order.getOrderId());
        System.out.println(order.getSize());
        System.out.println(order.getTableNumber());
        System.out.println(order.getTimeStamp());
        // Now delete the order we just created to keep the DB tidy
        DeleteOrder orderToDelete = new DeleteOrder(String.valueOf(order.getOrderId()));
        orderToDelete.writePayload();
    }
    @Test
    public void postAnOrderWithPizzaDetails(){
        PostOrder order = new PostOrder("Cheesy", "Curry", "Medium", 5);
        order.writePayload();
        // Now delete the order we just created to keep the DB tidy
        DeleteOrder orderToDelete = new DeleteOrder(String.valueOf(order.getOrderId()));
        orderToDelete.writePayload();
    }
}
