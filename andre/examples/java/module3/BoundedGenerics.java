import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BoundedGenerics {

    static  void printList(List<? extends Number> list) {
        for (Number n : list) {
            System.out.println(n.doubleValue());
        }
    }

    static  void addToList(List<? super Integer> list) {
        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }
    }

    public static void main(String[] args) {

        List<Integer> intList = Arrays.asList(1, 2, 3, 4);
        List<Double> doubleList = Arrays.asList(1.1, 2.3, 3.14, 4.8);

        //works for Number or subtypes of that.
        printList(intList);
        printList(doubleList);

        addToList(intList); //fine
        addToList(doubleList); //illegal

        // superclass Number of Integer works too
        List<Number> mixedList = new ArrayList<>();
        mixedList.add(1);
        mixedList.add(1.2);

        addToList(mixedList);
    }
}
