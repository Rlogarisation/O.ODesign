package examRefactoring;

public class Woolies extends Supermarket{
    private String cardName = "Everyday Rewards";

    public void outputMessage() {
        System.out.println("Welcome! Please scan your first item. If you have a " + cardName + " card, please scan it at any time.");
    }
}
