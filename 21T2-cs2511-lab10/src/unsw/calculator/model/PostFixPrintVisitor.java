package unsw.calculator.model;

import unsw.calculator.model.tree.BinaryOperatorNode;
import unsw.calculator.model.tree.NumericNode;

public class PostFixPrintVisitor implements Visitor {
    /**
     * Visits a composite node in the expression tree.
     * @param node
     */
    @Override
    public void visitBinaryOperatorNode(BinaryOperatorNode node) {
        if (node.getLeft() != null) {
            node.getLeft().accept(this);
        }
        
        if (node.getRight() != null) {
            node.getRight().accept(this);
        }

        System.out.print(node.getLabel() + " ");

    }
    
    /**
     * Visits a compound node in the expression tree.
     * @param node
     */
    @Override
    public void visitNumericNode(NumericNode node) {
        System.out.print(node.getLabel() + " ");
    }
}