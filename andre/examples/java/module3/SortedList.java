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
}

/*

I want to:

SortedList<LinkedList<Integer>> l = new SortedList<>()

... random adds


 */
