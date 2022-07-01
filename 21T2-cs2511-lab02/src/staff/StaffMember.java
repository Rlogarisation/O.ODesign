package staff;


/**
 * A staff member
 * @author Robert Clifton-Everest
 *
 */
public class StaffMember {

    protected String name;
    protected Double salary;
    protected int hireDate;
    protected int endDate; 


    /**
     * Storing staff member’s name, salary, hire date, and end date.
     * @param name
     * @param salary
     * @param hireDate
     * @param endDate
     * @return
     */
    public StaffMember(String name, Double salary, int hireDate, int endDate) {
        this.setName(name);
        this.setSalary(salary);
        this.setHireDate(hireDate);
        this.setEndDate(endDate);
    }

    /**
     * Name setter for staff member.
     * @param name
     */
    void setName(String name) {
        this.name = name;
    }

    /**
     * Salary setter for staff member.
     * @param salary
     */
    void setSalary(Double salary) {
        this.salary = salary;
    }

    /**
     * hire date setter for staff member.
     * @param hireDate
     */
    void setHireDate(int hireDate) {
        this.hireDate = hireDate;
    }

    /**
     * end date setter for staff member.
     * @param endDate
     */
    void setEndDate(int endDate) {
        this.endDate = endDate;
    }

    /**
     * Name getter for staff member.
     * @return name of staff member as string.
     */
    String getName() {
        return this.name;
    }
    /**
     * Salary getter for staff member.
     * @return salary as double.
     */
    Double getSalary() {
        return this.salary;
    }
    /**
     * Hire date getter for staff member.
     * @return Hire date as int.
     */
    int getHireDate() {
        return this.hireDate;
    }
    /**
     * End date getter for staff member.
     * @return End date as Localdate.
     */
    int getEndDate() {
        return this.endDate;
    }

    @Override
    public String toString() {
        String msg = this.getName() + ", salary: " + this.getSalary() + 
        ", Period of work: " + this.getHireDate() + " - " + 
        this.getEndDate();
        return msg;
    }

    @Override
    public boolean equals(Object obj) {
        /**
         * Object obj basically takes into any type of input, 
         * and proceed in the function.
         */
        if (obj == null) { return false; }
        /**
         * Comparing two address at this line,
         * If two addresses are equal,
         * then it must return true.
         * Otherwise keep proceed to check whether they're equal.
         */
        if (obj == this) { return true; }

        /**
         * Comparing two classes. 
         */ 
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        /**
         * Object cannot changed adaptively to current class.
         * Hence we need to specify the class.
         */
        StaffMember other = (StaffMember) obj;

        /**
         * Then finally compare the key values in the class.
         */
        if (this.getName() == other.getName() && 
        this.getSalary() == other.getSalary() &&
        this.getHireDate() == other.getHireDate() && 
        this.getEndDate() == other.getEndDate()) {
            return true;
        }
        else {
            return false;
        }
    }

}



