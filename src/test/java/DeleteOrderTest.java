import functionality.endpoints.DeleteOrder;
import functionality.endpoints.PostOrder;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static functionality.endpoints.GenericMethodTest.printList;
import static functionality.endpoints.GenericMethodTest.printSquare;

public class DeleteOrderTest {
    @Test
    public void typeWildcardTest() {
        List<Double> doubles = new ArrayList<Double>();
        doubles.add(1.0);
        doubles.add(2.0);
        doubles.add(3.0);
        printSquare(doubles);

        List<Integer> ints = new ArrayList<Integer>();
        ints.add(1);
        ints.add(2);
        ints.add(3);
        printSquare(ints);

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
    public void genericMethodTest(){
        List<String> ints = new ArrayList<String>();
        ints.add("1");
        ints.add("2");
        ints.add("3");
        printList(ints);
    }
}
