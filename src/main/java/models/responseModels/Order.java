package models.responseModels;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Crust",
        "Order_ID",
        "Flavor",
        "Size",
        "Table_No",
        "Timestamp"
})
public class Order {
    @JsonProperty("Flavor")
    public String flavor;
    @JsonProperty("Crust")
    public String crust;
    @JsonProperty("Order_ID")
    public Integer orderID;
    @JsonProperty("Size")
    public String size;
    @JsonProperty("Table_No")
    public Integer tableNo;
    @JsonProperty("Timestamp")
    public String timestamp;
}
