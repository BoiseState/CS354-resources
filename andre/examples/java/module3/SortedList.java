import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SortedList<T extends Comparable<T>> {

    private List<T> sortedList;

    public SortedList(List<T> list) {
        this.sortedList = list;
    }

    public void add(T num) {
        if (!this.sortedList.contains(num)) {
            int i = 0;
            while (i < sortedList.size() && sortedList.get(i).compareTo( num) < 0) {
                i++;
            }
            sortedList.add(i, num);
        }
    }

    private static void addRandoms(SortedList<Integer> list) {

        for (int i = 0; i < 10000; i++) {
            list.add((int)(Math.random()*10000));
        }
    }

    public static void main(String[] args) {
        SortedList<Integer> a = new SortedList<>(new ArrayList<Integer>());
        SortedList<Integer> l = new SortedList<>(new LinkedList<Integer>());

        long start = System.currentTimeMillis();
        addRandoms(a);
        System.out.println("ArrayList time = " + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        addRandoms(l);
        System.out.println("LinkedList time = " + (System.currentTimeMillis() - start));
    }
}

/*

I want to:

SortedList<LinkedList<Integer>> l = new SortedList<>()

... random adds


 */
