package bool;


public class NOT implements BooleanNode {
    private BooleanNode b;

    public NOT(BooleanNode b) {
        this.b = b;
    }

    public boolean determineLogic() {
        if (b.determineLogic() == true) {
            return false;
        }
        else {
            return true;
        }
    }

    public String print() {
        return "(NOT " + b.print() +  ")";
    }
}
