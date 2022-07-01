package programmingexample5;

import java.util.ArrayList;

public class ShapeGroup implements ShapeVisitable {

    private ArrayList<ShapeVisitable> elems;

    public ShapeGroup() {
        elems = new ArrayList<ShapeVisitable>();
    }

    public void add(ShapeVisitable shape) {
        elems.add(shape);
    }

    public void remove(ShapeVisitable shape) {
        elems.remove(shape);
    }

    @Override
    public void accept(ShapeVisitor v) {

        for (ShapeVisitable i : elems) {
            i.accept(v);
        }


    }

}
