import functionality.endpoints.GetOrder;
import functionality.endpoints.PostOrder;
import org.junit.Test;

public class PostOrderTest {
    @Test
    public void postAnOrder(){
        PostOrder order = new PostOrder();
        order.writePayload();
    }
}
