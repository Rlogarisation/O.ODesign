package programmingexample6;

public class FreeShippingDecorator extends Decorator {
    double myPrice;
    int myWeight;

    public FreeShippingDecorator(Product myProduct, double price, int weight) {
        super(myProduct);
        myPrice = price;
        myWeight = weight;
    }

    public double getShippingCost() {
        if (product.getPrice() >= myPrice && product.getWeight() <= myWeight) {
            return 0;
        }
        return product.getShippingCost();
    }


}
