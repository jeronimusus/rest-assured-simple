import models.responseModels.Order;
import functionality.endpoints.GetOrders;
import models.responseModels.Orders;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.matchesPattern;

public class GetOrdersTest {

    @Test
    public void getOrders(){
        GetOrders orders = new GetOrders(true);
        orders.writePayload();
        System.out.println(orders.getResponse().getStatusCode());
        assertThat(200, equalTo(orders.getResponse().getStatusCode()));

        // Add all orders to an array of type Order
        Order[] moreAllOrders = orders.getBody().as(Order[].class);

//        Orders willThisWork = orders.getBody().as(Orders.class);

        System.out.println("Array of type Order " + moreAllOrders[0].flavor);
        // Add all the individual Orders in to an Array of type IndividualOrder
        // This is identical to the above in that you wind up with an Array of Orders
        Order[] arrayOfOrders = orders.getPayloadJson().getObject("", Order[].class);
        for(Order order : arrayOfOrders)
        {
            System.out.println("Order Timestamp again " + order.timestamp);
        }

        // Add all order crusts to a List of type String
        List<String> crusts = orders.getPayloadJson().getList("Crust");
        System.out.println(crusts.size());
        if (crusts.size() >= 2) {
            System.out.println(crusts.get(0));
            System.out.println(crusts.get(1));
        }
        // Add all the individual Orders to a List of type IndividualOrder
        List<Order> allOrders = orders.getPayloadJson().getList("", Order.class);
        for(Order order : allOrders)
        {
            System.out.println("Order Timestamp: " + order.timestamp);
            assertThat(order.timestamp, matchesPattern("^^[1-9]\\d{3}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}.\\d{6}$"));
        }


    }
}
