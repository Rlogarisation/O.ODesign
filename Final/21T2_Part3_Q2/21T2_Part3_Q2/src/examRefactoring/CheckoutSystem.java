package examRefactoring;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class CheckoutSystem {

    private Supermarket supermarketClass;
    private int amountPurchased;

    public void setAmountPurchased(int money) {
        amountPurchased = money;
    }

    public int getAmountPurchased() {
        return amountPurchased;
    }

    private CheckoutSystem(String supermarket) {
        if (supermarket.equals("Coles")) {
            supermarketClass = new Coles();
        } else if (supermarket.equals("Woolies")) {
            supermarketClass = new Woolies();
        }

        // orginal implementation
//        this.supermarket = supermarket;
    }

    public static CheckoutSystem instance(String supermarket) {
        return new CheckoutSystem(supermarket);
    }

    public void checkout(List<Item> items, String paymentMethod, int paymentAmount, boolean receipt) {
        // Welcome the user
//        String cardName = null;
//        if (supermarket.equals("Coles")) {
//            cardName = "flybuys";
//        } else if (supermarket.equals("Woolies")) {
//            cardName = "Everyday Rewards";
//        }
//        System.out.println("Welcome! Please scan your first item. If you have a " + cardName + " card, please scan it at any time.");
        supermarketClass.outputMessage();

        // Scan the items
        scanItems(items);
        
        // Take the user's payment
//        if (paymentAmount < amountPurchased) {
//            System.out.println("Not enough $$$.");
//            return;
//        }
//
//        if (paymentMethod.equals("cash")) {
//            System.out.println("Paid $" + paymentAmount + " with $" + (paymentAmount - amountPurchased) + " change.");
//        } else {
//            paymentAmount = amountPurchased;
//            System.out.println("Paid $" + paymentAmount + ".");
//        }
        Payment myPayment = new Payment(paymentAmount, getAmountPurchased(), paymentMethod);
        myPayment.amountCheck();
        myPayment.paymentMethod();

        // Print the receipt
        if (receipt) {
            if (supermarketClass instanceof Woolies) {
                System.out.print("Your purchase: ");
    
//                for (int i = 0; i < items.size() - 1; i++) {
//                    System.out.print(items.get(i).getName() + ", ($" + items.get(i).getPrice() + "), ");
//                }
                for (Item i : items) {
                    String nameOfItem = i.getName();
                    int priceOfItem = i.getPrice();
                    System.out.print(nameOfItem + ", ($" + priceOfItem + "), ");
                }

//                System.out.println(items.get(items.size() - 1).getName() + " ($" + items.get(items.size() - 1).getPrice() + ").");
            } else if (supermarketClass instanceof Coles) {
                System.out.println("Today at Coles you purchased the following:");
                
                for (Item item : items) {
                    System.out.println("- " + item.getName() + " : $" + item.getPrice());
                }
            } 
        }
    }

    public void scanItems(List<Item> items) {
        int sum = 0;
        // Supermarkets have restrictions on the number of items allowed
        if (supermarketClass instanceof Coles) {
            if (items.size() > 20) {
                System.out.println("Too many items.");
            }
        } else if (supermarketClass instanceof Woolies) {
            if (items.size() >= 55) {
                System.out.println("Sorry, that's more than we can handle in a single order!");
            }
        }

        if (items.size() == 0) {
            System.out.println("You do not have any items to purchase.");
            return;
        }

        for (Item item : items) {
            sum += item.getPrice();
        }

        setAmountPurchased(sum);
    }

    public static void main(String[] args) {
        List<Item> items = new ArrayList<Item>(Arrays.asList(
            new Item("Apple", 1),
            new Item("Orange", 1),
            new Item("Avocado", 5)
        ));

        CheckoutSystem checkout = new CheckoutSystem("Woolies");
        checkout.checkout(items, "cash", 200, true);
    }

}