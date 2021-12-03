import functionality.endpoints.Auth;
import functionality.endpoints.DeleteOrder;
import functionality.interfaces.IRestResponse;
import functionality.endpoints.PostOrder;
import functionality.interfaces.RestResponse;
import models.responseModels.AuthSuccessResponse;
import models.responseModels.Delete;
import models.responseModels.Order;
import org.junit.Test;

public class ResponseInterfaceTest {
    @Test
    public void postOrderWithGenericInterface() {
        PostOrder order = new PostOrder(true);

        // Declare IRestResponse as type Order and instantiate with the RestResponse interface
        IRestResponse<Order> intResponse = new RestResponse(Order.class, order.getResponse());
        System.out.println("Order timestamp: " + intResponse.getBodyAsPojo().timestamp);
        System.out.println("Status Code: " + intResponse.getStatusCode());
        System.out.println("Status Code description: " + intResponse.getStatusDescription());
        System.out.println("Got a success response code: " + intResponse.isSuccessful());

        // Now delete the order we just created to keep the DB tidy
        DeleteOrder orderToDelete = new DeleteOrder(true, String.valueOf(order.getOrderId()));
        orderToDelete.writePayload();
    }
    @Test
    public void deleteOrderWithGenericInterface() {
        // First create an Order to delete
        PostOrder order = new PostOrder(true, "Cheesy", "Curry", "Medium", 5);
        order.writePayload();
        // Now delete the order we just created to keep the DB tidy
        DeleteOrder orderToDelete = new DeleteOrder(true, String.valueOf(order.getOrderId()));
        orderToDelete.writePayload();
        // Declare IRestResponse as type Delete and instantiate it with the RestResponse interface
        IRestResponse<Delete> intResponse = new RestResponse<>(Delete.class, orderToDelete.getResponse());
        System.out.println(intResponse.getBodyAsString());
    }
    @Test
    public void getAuthWithGenericInterface() {
        Auth authentication = new Auth();
        System.out.println(authentication.getAccessToken());
        // Declare IRestResponse as type AuthSuccessResponse and instantiate it with the RestResponse interface
        IRestResponse<AuthSuccessResponse> intResponse = new RestResponse<>(AuthSuccessResponse.class, authentication.getResponse());
        System.out.println(intResponse.getBodyAsString());
    }
}
