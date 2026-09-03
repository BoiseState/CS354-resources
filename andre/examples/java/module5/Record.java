record Point(int x, int y){}

public class Record {

    public static void main(String[] args) {

        Point p = new Point(1, 2);

        // no boilerplate for these
        p.hashCode();
        p.x();
        p.y();
    }
}
