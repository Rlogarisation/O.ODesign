public class CircleWithGetter {
    protected static final double pi = 3.14159;
    protected int x, y;
    protected int r;

    public CircleWithGetter(int x, int y, int r) {
        setX(x);
        setY(y);
        setR(r);
    }

    public int setX(int x) {
        return this.x = x;
    }
    public int setY(int y) {
        return this.y = y;
    }
    public int setR(int r) {
        return this.r = r;
    }

    public int getX() {
        return this.x;
    }
    public int getY() {
        return this.y;
    }
    public int getR() {
        return this.r;
    }

    public double circumference() {
        return 2 * pi * r;
    }

    public double area() {
        return pi * r * r;
    }


    public static void main(String[] args) {
        var circleA = new CircleWithGetter(1, 1, 1);
        circleA.setR(2);
        System.out.println(circleA.getR());
        System.out.println(circleA.circumference());
        System.out.println(circleA.area());
    }
}
