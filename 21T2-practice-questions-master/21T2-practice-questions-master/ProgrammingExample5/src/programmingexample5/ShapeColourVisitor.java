package programmingexample5;

import java.awt.*;

public class ShapeColourVisitor implements ShapeVisitor {

    @Override
    public void visit(Circle myCircle) {
        myCircle.setColour(Color.RED);
    }

    @Override
    public void visit(Triangle myTriangle) {
        myTriangle.setColour(Color.BLUE);
    }

    @Override
    public void visit(Rectangle myRectangle) {
        myRectangle.setColour(Color.GREEN);
    }

}
