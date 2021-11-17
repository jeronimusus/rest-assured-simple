package functionality.endpoints;

import functionality.interfaces.IRestResponse;
import functionality.interfaces.RestResponse;
import models.responseModels.AuthSuccessResponse;
import models.responseModels.Delete;

import static functionality.SetupEnvironment.buildEnv;

public class DeleteOrder extends EndpointSuper {
    private IRestResponse<Delete> intResponse;
    // Constructor with specified order to delete
    public DeleteOrder(boolean doCall,String orderId) {
        System.out.println("In Delete Order endpoint");
        requestSpec = buildEnv();
        url = "/api/orders/" + orderId;
        if (doCall) {
            deletePayload();
            setPojoResponse();
        }
    }
    private void setPojoResponse(){
        intResponse = new RestResponse<>(Delete.class, getResponse());
    }
    public IRestResponse<Delete> getPojoResponse() {return this.intResponse;}
}
