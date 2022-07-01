package examRefactoring;

public class Coles extends Supermarket {
    private String cardName = "flybuys";

    public void outputMessage() {
        System.out.println("Welcome! Please scan your first item. If you have a " + cardName + " card, please scan it at any time.");
    }
}
