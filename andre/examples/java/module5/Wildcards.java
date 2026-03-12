import java.util.LinkedList;
import java.util.List;

public class Wildcards {

    static <T> LinkedList<T> asList(T... params) {
        LinkedList<T> list = new LinkedList<>();
        for (T elem: params) {
            list.add(elem);
        }

        return list;
    }

    static void printObjectList(List<Object> list) {
        for (Object elem : list) {
            System.out.println(elem + " ");
        }
    }


    static void printWildcardList(List<?> list) {
        for (Object elem : list) {
            System.out.println(elem + " ");
        }
    }


    public static void main(String[] args) {

        List<Integer> intList = asList(1, 2, 3);

        // printObjectList(intList);

        List<Object> intObjectList = asList(1, 2, 3);

        // printObjectList(intList);

        printWildcardList(intList);
        printWildcardList(intObjectList);

        List<?> wildCardList = asList(1, 2, "hello"); // wildcard capture

        //wildCardList.add(12);
        //wildCardList.add(null);

        printWildcardList(wildCardList);

        // are we confused by this feature yet?


    }
}
