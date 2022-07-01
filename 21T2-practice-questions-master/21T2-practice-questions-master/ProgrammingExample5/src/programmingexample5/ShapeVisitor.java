package programmingexample5;

public interface ShapeVisitor {
	public void visit(Circle myCircle);
	public void visit(Rectangle myRectangle);
	public void visit(Triangle myTriangle);
}
