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

        // Add all order crusts to a List of type String
        List<String> crusts = orders.getPayloadJson().getList("Crust");
        System.out.println(crusts.get(0));
        System.out.println(crusts.get(1));

        // Add all the individual Orders to a List of type IndividualOrder
        List<IndividualOrder> allOrders = orders.getPayloadJson().getList("", IndividualOrder.class);
        for(IndividualOrder order : allOrders)
        {
            System.out.println("Order Timestamp: " + order.Timestamp);
            assertThat(order.Timestamp, matchesPattern("^^[1-9]\\d{3}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}.\\d{6}$"));
        }

        // Add all the individual Orders in to an Array of type IndividualOrder
        IndividualOrder[] arrayOfOrders = orders.getPayloadJson().getObject("", IndividualOrder[].class);
        for(IndividualOrder order : arrayOfOrders)
        {
            System.out.println("Order Timestamp again " + order.Timestamp);
        }
    }
}
