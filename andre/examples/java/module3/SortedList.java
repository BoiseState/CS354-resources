import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SortedList<E extends Comparable<E>, T extends List<E>> {

    private T sortedList;

    public SortedList(T list) {
        this.sortedList = list;
    }

    public void add(E num) {
        if (!sortedList.contains(num)) {
            int i = 0;
            while (i < sortedList.size() && sortedList.get(i).compareTo( num) < 0) {
                i++;
            }
            sortedList.add(i, num);
        }
    }

    private static void addRandoms(SortedList<Integer, List<Integer>> list) {

        for (int i = 0; i < 10000; i++) {
            list.add((int)(Math.random()*10000));
        }
    }

    public static void main(String[] args) {
        SortedList<Integer, List<Integer>> a = new SortedList<>(new ArrayList<>());
        SortedList<Integer, List<Integer>> l = new SortedList<>(new LinkedList<>());

        long start = System.currentTimeMillis();
        addRandoms(a);
        System.out.println("ArrayList time = " + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        addRandoms(l);
        System.out.println("LinkedList time = " + (System.currentTimeMillis() - start));
    }
}
