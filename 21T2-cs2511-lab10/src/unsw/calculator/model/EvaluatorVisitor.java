package unsw.calculator.model;

import java.util.Stack;

import unsw.calculator.model.tree.BinaryOperatorNode;
import unsw.calculator.model.tree.NumericNode;

public class EvaluatorVisitor implements Visitor { 
    private Stack<Integer> operands = new Stack<Integer>();
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

        int b = operands.pop();
        int a = operands.pop();
        operands.push(node.compute(a, b));
        
    }
    
    /**
     * Visits a compound node in the expression tree.
     * @param node
     */
    @Override
    public void visitNumericNode(NumericNode node) {
        operands.push(node.getValue());
    }

    public int getValue() {
        return operands.pop();
    }
}