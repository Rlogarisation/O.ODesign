package programmingexample5;

import java.awt.Color;

public class ShapeColourAreaVisitor implements ShapeVisitor {
    private Color myColor;
    private double totalArea = 0;


    public ShapeColourAreaVisitor(Color colour) {
        myColor = colour;
    }

    public double getTotalArea() {
        return totalArea;
    }

    @Override
    public void visit(Circle myCircle) {
        if (myCircle.getColour().equals(myColor)) {
            totalArea += myCircle.area();
        }

    }

    @Override
    public void visit(Triangle myTriangle) {
        if (myTriangle.getColour().equals(myColor)) {
            totalArea += myTriangle.area();
        }

    }

    @Override
    public void visit(Rectangle myRectangle) {
        if (myRectangle.getColour().equals(myColor)) {
            totalArea += myRectangle.area();
        }
    }

}
