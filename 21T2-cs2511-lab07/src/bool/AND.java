package bool;

public class AND implements BooleanNode {
    private BooleanNode b1;
    private BooleanNode b2;

    public AND(BooleanNode b1, BooleanNode b2) {
        this.b1 = b1;
        this.b2 = b2;
    }

    public boolean determineLogic() {
        if (b1.determineLogic() == true && b2.determineLogic() == true) {
            return true;
        }
        else {
            return false;
        }
    }

    public String print() {
        return "(AND " + b1.print() + " " + b2.print() + ")";
    }

}
