package examRefactoring;

public abstract class Supermarket {
    private String cardName;

    public Supermarket() {

    }
    /**
     * The output message when initiate the system
     */
    public void outputMessage(){
        System.out.println("Welcome! Please scan your first item. If you have a " + cardName + " card, please scan it at any time.");
    }



}
