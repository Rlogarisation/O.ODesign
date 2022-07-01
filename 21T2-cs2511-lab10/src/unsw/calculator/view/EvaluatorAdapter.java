package unsw.calculator.view;

import unsw.calculator.model.*;
import unsw.calculator.model.tree.*;

public class EvaluatorAdapter implements Evaluator {
    public int evaluate(String expression) {
        Parser parser = new Parser(expression);
        TreeNode node = parser.parse();
        EvaluatorVisitor evaluatorVisitor = new EvaluatorVisitor();
        node.accept(evaluatorVisitor);
        return evaluatorVisitor.getValue();
    }
}