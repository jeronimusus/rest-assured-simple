import ResponseModels.IndividualOrder;
import functionality.endpoints.GetOrders;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.matchesPattern;

public class GetOrderTest {
    @Test
    public void getOrders(){
        GetOrders orders = new GetOrders(true);
        orders.writePayload();
        System.out.println(orders.getResponse().getStatusCode());
        assertThat(200, equalTo(orders.getResponse().getStatusCode()));
        // Add all the individual Orders to a list
        List<IndividualOrder> allOrders = orders.getPayloadJson().getList("", IndividualOrder.class);
        for(IndividualOrder order : allOrders)
        {
            System.out.println("Order Timestamp: " + order.Timestamp);
            assertThat(order.Timestamp, matchesPattern("^^[1-9]\\d{3}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}.\\d{6}$"));
        }
    }
}
