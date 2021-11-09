package functionality.endpoints;

import io.restassured.specification.RequestSpecification;
import models.requestModels.PostOrderRequestBody;
import org.json.simple.JSONObject;

import static functionality.SetupEnvironment.buildEnv;

public class PostOrder extends EndpointSuper {
    private String crust;
    private String flavor;
    private Integer orderId;
    private String size;
    private Integer tableNumber;
    private String timeStamp;
    // Empty Constructor, hardcoded order will be used
    public PostOrder(boolean doCall) {
        System.out.println("In Post Order endpoint with hardcoded order");
        setupRequest("crusty crust", "flavoursome flavour", "sizeable size", 74362);
        if (doCall) {
            postPayload();
            setAllSetters();
        }
    }
    // Constructor with all Order details
    public PostOrder(boolean doCall, String crust, String flavor, String size, int TableNumber) {
        System.out.println("In Post Order endpoint with bespoke order details");
        setupRequest(crust, flavor, size, TableNumber);
        if (doCall) {
            postPayload();
            setAllSetters();
        }
    }
    // Sets up all that is needed for Rest Assured to make the call
    private void setupRequest(String crust, String flavor, String size, int TableNumber){
        requestSpec = buildEnv();
        Auth authentication = new Auth();
        requestSpec.header("Authorization", "Bearer " + authentication.getAccessToken());
        PostOrderRequestBody body = new PostOrderRequestBody(crust, flavor, size, TableNumber);
        requestSpec.body(body);
        url = "/api/orders";
    }
    // Getters and Setters
    private void setCrust(){crust = getPayloadJson().get("Crust");}
    public String getCrust(){
        return crust;
    }
    private void setFlavor(){flavor = getPayloadJson().get("Flavor");}
    public String getFlavor(){
        return flavor;
    }
    private void setOrderId(){orderId = getPayloadJson().get("Order_ID");}
    public int getOrderId(){return orderId;}
    private void setSize(){size = getPayloadJson().get("Size");}
    public String getSize(){
        return size;
    }
    private void setTableNumber(){tableNumber = getPayloadJson().get("Table_No");}
    public int getTableNumber(){
        return tableNumber;
    }
    private void setTimeStamp(){timeStamp = getPayloadJson().get("Timestamp");}
    public String getTimeStamp(){
        return timeStamp;
    }
    private void setAllSetters(){
        setCrust();
        setFlavor();
        setOrderId();
        setSize();
        setTableNumber();
        setTimeStamp();
    }
}
