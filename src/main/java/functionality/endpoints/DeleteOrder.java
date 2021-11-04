package functionality.endpoints;

import static functionality.SetupEnvironment.buildEnv;

public class DeleteOrder extends EndpointSuper {
    // Constructor with specified order to delete
    public DeleteOrder(boolean doCall,String orderId) {
        System.out.println("In Delete Order endpoint");
        requestSpec = buildEnv();
        url = "/api/orders/" + orderId;
        if (doCall) {deletePayload();}
    }
}
