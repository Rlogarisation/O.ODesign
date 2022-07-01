package banking;

import java.util.*;

public class LoggedBankAccount extends BankAccount {

    private List<String> actions;

    public LoggedBankAccount() {
        super();
        actions = new ArrayList<String>();
    }
    
    /**
     * @pre deposit amount must be positive number.
     * @post successful deposition guarantee.
     * @param amount positive double.
     * @invarent amount > 0 && currentBalance >= 0
     */
    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            currentBalance += amount;
            actions.add("deposite: " + amount);
        }
    } 

    /**
     * @pre currentBalance must have more than withdrawl amount.
     * @post withdraw required amount of money.
     * @param amount positive double.
     * @return the amount of money will be withdraw.
     * @invarient currentBalance >= 0.
     */
    @Override
    public double withdraw(double amount) {
        if (amount > 0 && amount <= currentBalance) {
            currentBalance -= amount;
            actions.add("withdraw: " + amount);
            return amount;
        }
        else {
            return 0;
        }
    } 
    



}
