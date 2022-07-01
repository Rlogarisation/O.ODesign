package banking;

public class BankAccount {
    /**
     * @pre currentBalance >= 0
     */
    protected double currentBalance = 0;

    public BankAccount() {
        currentBalance = 0;
    }

    /**
     * @pre deposit amount must be positive number.
     * @post successful deposition guarantee.
     * @param amount positive double.
     * @invarent amount > 0
     */
    public void deposit(double amount) {
        if (amount > 0) {
            currentBalance += amount;
        }
    } 

    /**
     * @pre currentBalance must have more than withdrawl amount.
     * @post withdraw required amount of money.
     * @param amount positive double.
     * @return the amount of money will be withdraw.
     * @invarient currentBalance > 0.
     */
    public double withdraw(double amount) {
        if (amount > 0 && amount <= currentBalance) {
            currentBalance -= amount;
            return amount;
        }
        else {
            return 0;
        }
    } 
}