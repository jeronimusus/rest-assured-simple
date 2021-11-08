package models.requestModels;

public class PostOrderRequestBody {
    public String Crust;
    public String Flavor;
    public String Size;
    public Integer Table_No;

    /**
     * No args constructor for use in serialization
     *
     */
    public PostOrderRequestBody() {
    }

    /**
     *
     * @param flavor
     * @param size
     * @param crust
     * @param tableNo
     */
    public PostOrderRequestBody(String crust, String flavor, String size, Integer tableNo) {
        super();
        this.Crust = crust;
        this.Flavor = flavor;
        this.Size = size;
        this.Table_No = tableNo;
    }
}
