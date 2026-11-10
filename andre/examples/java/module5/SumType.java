sealed interface Shape permits Circle, Rectangle {}

record Circle(double radius) implements Shape {}

record Rectangle(double width, double height) implements Shape {}

public class SumType {

    public static double area(Shape s) {
        return switch (s) {
            case Circle c ->
                Math.PI * c.radius() * c.radius();
            case Rectangle r ->
                r.width() * r.height();
        };
    }

    public static void main(String ...args) {
        Circle c = new Circle(2);
        Rectangle r = new Rectangle(2, 4);
        System.out.println(area(c));
        System.out.println(area(r));
    }
}