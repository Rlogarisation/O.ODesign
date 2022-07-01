package part3q1;

public class Lunch extends ExtraServiceDecorator{
    Room myRoom;

    /**
     * Constructor for extra service lunch.
     */
    public Lunch() {}

    /**
     * Extra cost for lunch
     */
    @Override
    public int getCostForEachDay() {return 0;}
}
