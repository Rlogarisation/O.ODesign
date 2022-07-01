package programmingexample6;

public class DiscountDecorator extends Decorator {
    private int discountPercentage;
    private double currentPrice;
    public DiscountDecorator(Product myProduct, int discount) {
        super(myProduct);
        currentPrice = myProduct.getPrice();
        discountPercentage = discount;
    }

    @Override
    public double getPrice() {
        return currentPrice * (1 - discountPercentage * 0.01);
    }

}
