import functionality.endpoints.GetOrder;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class GetOrderTest {
    @Test
    public void getAnOrder(){
        GetOrder order = new GetOrder(true);
        order.writePayload();
        System.out.println(order.getResponse().getStatusCode());
        assertThat(200, equalTo(order.getResponse().getStatusCode()));
    }
}
