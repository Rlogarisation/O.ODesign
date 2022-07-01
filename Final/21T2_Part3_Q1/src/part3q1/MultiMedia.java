package part3q1;

public class MultiMedia extends ExtraServiceDecorator{
    Room myRoom;

    /**
     * Constructor for extra service media.
     */
    public MultiMedia() {}

    /**
     * Extra cost for media
     */
    @Override
    public int getCostForEachDay() {return 0;}
}

