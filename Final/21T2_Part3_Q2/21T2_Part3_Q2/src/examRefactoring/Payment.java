package examRefactoring;

public class Payment {
    private int payment;
    private int amount;
    private String method;

    public Payment(int paymentAmount, int amountPurchased, String paymentMethod) {
        payment = paymentAmount;
        amount = amountPurchased;
        method = paymentMethod;
    }

    public void amountCheck() {
        if (payment < amount) {
            System.out.println("Not enough $$$.");
        }
    }

    public void paymentMethod() {
        if (method.equals("cash")) {
            System.out.println("Paid $" + payment + " with $" + (payment - amount) + " change.");
        }
        else {
            payment = amount;
            System.out.println("Paid $" + payment + ".");
        }
    }


}
