package bool;

public class Boo implements BooleanNode{
    private boolean b;

    public Boo(boolean b) {
        this.b = b;
    }

    public boolean determineLogic() {
        return b;
    }

    public String print() {
        return "" + b;
    }
}
