package part3q1;

public class Dinner extends ExtraServiceDecorator{
    Room myRoom;

    /**
     * Constructor for extra service dinner.
     */
    public Dinner() {}

    /**
     * Extra cost for dinner
     */
    @Override
    public int getCostForEachDay() {return 0;}
}
