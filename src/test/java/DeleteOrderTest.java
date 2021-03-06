import dataProvider.ConfigFileReader;
import functionality.endpoints.DeleteOrder;
import functionality.endpoints.PostOrder;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static functionality.endpoints.GenericMethodTest.printList;
import static functionality.endpoints.GenericMethodTest.printSquare;

public class DeleteOrderTest {

    @Test
    public void hackerRank() {
    }
    @Test
    public void deleteAnOrderTest(){
        // First create an Order to delete
        PostOrder order = new PostOrder(true, "Cheesy", "Curry", "Medium", 5);
        order.writePayload();
        // Now delete the order we just created to keep the DB tidy
        DeleteOrder orderToDelete = new DeleteOrder(true, String.valueOf(order.getOrderId()));
        orderToDelete.writePayload();
        System.out.println("Delete message from POJO: " + orderToDelete.getPojoResponse().getBodyAsPojo().message);
    }
    @Test
    public void deleteOrderFail(){
        DeleteOrder orderToDelete = new DeleteOrder(true, "42345325");
        orderToDelete.getResponse().then().log().ifValidationFails().statusCode(404);
        orderToDelete.getResponse().then().statusCode(404);
    }
    @Test
    public void genericMethodTest(){
        List<String> ints = new ArrayList<String>();
        ints.add("1");
        ints.add("2");
        ints.add("3");
        printList(ints);
    }
}
