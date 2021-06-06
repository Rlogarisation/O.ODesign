public class Circle extends Object{

    private static final double PI = 3.14159;

    private int x = 0, y = 0;
    private int r = 6;

    static int no_circles = 0;

    public Circle() {
        // Usage of Super see in Animal.java
        // But what is the purpose of running thro local variables here?
        super();
        no_circles++;
    }

    public Circle(int x, int y, int r) {
        // This is calling previous class of increasing no_circle++.
        // Equivalent to calling Circle(), but avoided repeated code.
        this();
        this.x = x;
        this.y = y;
        this.r = r;
  
    }


    public Circle(int x, int y) {
        // Go to previous instructor, with self-deciding radius. 
        // Equivalent to Circle(x, y, 5);
        this(x, y, 5);
    }

    public double getArea() {
        return PI * r * r;
    }

    /**
     * Indicates that a method declaration is intended to override a method declaration in a supertype.
     * Must written with same signature, which is same return type and same function name.
     * In order to produce our own output format rather than default format.
     */

    @Override
    public String toString() {
        String msg = "[" + x + ", " + y + "]";
        return msg;
    }

    // Object obj basically takes into any type of input, 
    // and proceed in the function.
    @Override
    public boolean equals(Object obj) {
   
        if(obj == null) { return false; }
        if(obj == this) { return true; }

        // Does it mean the name of the class? e.g Circle?
        // Yes.
        if(this.getClass() != obj.getClass()){
            return false;
        }

        // both are of type Circle at this point.
        Circle other = (Circle) obj;

        
        if(this.x == other.x && this.y == other.y && this.r == other.r){
            return true;
        }
        else {
            return false;
        }
         
    }
    
    // Getter and Setter below ..
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }


}