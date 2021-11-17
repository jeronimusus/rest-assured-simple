import functionality.endpoints.DeleteOrder;
import functionality.interfaces.IRestResponse;
import functionality.endpoints.PostOrder;
import functionality.interfaces.RestResponse;
import models.responseModels.Order;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class PostOrderTest {
    @Test
    public void getOrderWithGenericInterface() {
        PostOrder order = new PostOrder(true);

        IRestResponse<Order> intResponse = new RestResponse(Order.class, order.getResponse());
        System.out.println(intResponse.getStatusCode());
        System.out.println(intResponse.getBody().Timestamp);

        // Now delete the order we just created to keep the DB tidy
        DeleteOrder orderToDelete = new DeleteOrder(true, String.valueOf(order.getOrderId()));
        orderToDelete.writePayload();
    }

    @Test
    public void postAnOrderWithNoDetails(){
        PostOrder order = new PostOrder(true);
        assertThat(201, equalTo(order.getResponse().getStatusCode()));
        order.writePayload();
        System.out.println("getClass result" + order.getClass());
        System.out.println(order.getCrust());
        System.out.println(order.getFlavor());
        System.out.println(order.getOrderId());
        System.out.println(order.getSize());
        System.out.println(order.getTableNumber());
        System.out.println(order.getTimeStamp());
        // Now delete the order we just created to keep the DB tidy
        DeleteOrder orderToDelete = new DeleteOrder(true, String.valueOf(order.getOrderId()));
        orderToDelete.writePayload();
    }
    @Test
    public void postAnOrderWithPizzaDetails(){
        PostOrder order = new PostOrder(true, "Cheesy", "Curry", "Medium", 5325);
        assertThat(201, equalTo(order.getResponse().getStatusCode()));
        order.writePayload();
        // Tests
        assertThat("Cheesy", equalTo(order.getCrust()));
        assertThat("Curry", equalTo(order.getFlavor()));
        assertThat("Medium", equalTo(order.getSize()));
        assertThat(5325, equalTo(order.getTableNumber()));
        // Now delete the order we just created to keep the DB tidy
        DeleteOrder orderToDelete = new DeleteOrder(true, String.valueOf(order.getOrderId()));
        orderToDelete.writePayload();
    }
    @Test
    public void PostOrderWithMissingAuthHeader(){
        // Set up the call, but don't POST, as we need to remove the Auth Header first
        PostOrder order = new PostOrder(false);
        // Remove the auth Header and Post the same payload again
        order.removeHeader("Authorization");
        order.postPayload(); // Now can POST as have removed Auth Header
        assertThat(401, equalTo(order.getResponse().getStatusCode()));
    }
}
