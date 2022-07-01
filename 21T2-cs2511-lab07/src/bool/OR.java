package bool;

public class OR implements BooleanNode {
    private BooleanNode b1;
    private BooleanNode b2;

    public OR(BooleanNode b1, BooleanNode b2) {
        this.b1 = b1;
        this.b2 = b2;
    }

    public boolean determineLogic() {
        if (b1.determineLogic() == false && b2.determineLogic() == false) {
            return false;
        }
        else {
            return true;
        }
    }

    public String print() {
        return "(OR " + b1.print() + " " + b2.print() + ")";
    }
}
