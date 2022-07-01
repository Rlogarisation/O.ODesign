package unsw.calculator.model;

import unsw.calculator.model.tree.BinaryOperatorNode;
import unsw.calculator.model.tree.NumericNode;

public class InFixPrintVisitor implements Visitor {

    /**
     * Visits a composite node in the expression tree.
     * @param node
     */
    @Override
    public void visitBinaryOperatorNode(BinaryOperatorNode node) {
        System.out.print("(");

        if (node.getLeft() != null) {
            node.getLeft().accept(this);
        }

        System.out.print(" " + node.getLabel() + " ");

        if (node.getRight() != null) {
            node.getRight().accept(this);
        }

        System.out.print(")");
    }
    
    /**
     * Visits a compound node in the expression tree.
     * @param node
     */
    @Override
    public void visitNumericNode(NumericNode node) {
        System.out.print(node.getLabel());
    }
}