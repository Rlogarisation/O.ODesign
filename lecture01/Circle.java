// First example in lecture,
// more formally should use getter and setters,
// but for simplicity we use simply function here.

public class Circle {
    protected static final double pi = 3.14159;
    protected int x, y;
    protected int r;

    public Circle() {
        this.x = 1;
        this.y = 1;
        this.r = 1;
    }

    public Circle(int x, int y, int r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }

    public double circumference() {
        return 2 * pi * r;
    }

    public double area() {
        return pi * r * r;
    }

    public static void main(String[] args) {
        var circleA = new Circle();
        System.out.println(circleA.circumference());
        System.out.println(circleA.area());

        System.out.println(circleA.x);

        circleA.x = 2;
        System.out.println(circleA.x);

    }
}
