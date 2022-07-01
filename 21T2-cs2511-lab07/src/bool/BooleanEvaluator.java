package bool;

public class BooleanEvaluator {
    private BooleanNode expression;

    public BooleanEvaluator(BooleanNode expression) {
        this.expression = expression;
    }

    public static boolean evaluate(BooleanNode expression) {
        // Return the expression evaluated
        return expression.determineLogic();
    }

    public static String prettyPrint(BooleanNode expression) {
        return expression.print();
    }

    public static void main(String[] args) {
        System.out.println(BooleanEvaluator.evaluate(new AND(new Boo(true), new Boo(true))));
        System.out.println(BooleanEvaluator.prettyPrint(new AND(new Boo(true), new Boo(true))));

        
        System.out.println(BooleanEvaluator.prettyPrint(new AND(new Boo(true), new NOT(new Boo(true)))));
    }

}