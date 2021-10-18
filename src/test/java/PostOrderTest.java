import functionality.endpoints.GetOrder;
import functionality.endpoints.PostOrder;
import org.junit.Test;

public class PostOrderTest {
    @Test
    public void postAnOrderWithNoDetails(){
        PostOrder order = new PostOrder();
        order.writePayload();
    }
    @Test
    public void postAnOrderWithPizzaDetails(){
        PostOrder order = new PostOrder("Cheesy", "Curry", "Medium", 5);
        order.writePayload();
    }
}
