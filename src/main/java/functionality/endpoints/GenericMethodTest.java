package functionality.endpoints;

import java.util.List;

public class GenericMethodTest {

    public static void printSquare(List<? extends Number> numbers) {
        for (Number n : numbers) {
            double d = n.doubleValue();
            System.out.println(d);
        }
    }

    public static <anything> void printList(List<anything> numbers) {
        for (anything n : numbers) {
            System.out.println(n);
        }
    }

}
