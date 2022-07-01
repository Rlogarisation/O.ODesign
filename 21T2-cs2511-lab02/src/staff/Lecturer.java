package staff;

// StaffMember has a Lecture, so it is "has-a" relationship.
public class Lecturer {
    StaffMember Roger;

    protected String school;
    protected Character acadamicStatus;

    /**
     * The info of lecturer.
     * @param name
     * @param salary
     * @param hireDate
     * @param endDate
     * @param school
     * @param acadamicStatus
     * @return
     */
    public Lecturer(String name, Double salary, int hireDate, 
                    int endDate, String school, Character acadamicStatus) {
        Roger = new StaffMember(name, salary, hireDate, endDate);

        this.setSchool(school);
        this.setAcadamicStatus(acadamicStatus);
    }


     
    /**
     * School setter for lecturer.
     * @param school
     */
    void setSchool(String school) {
        this.school = school;
    }
    /**
     * Acadamic Status setter for lecturer.
     * @param acadamicStatus
     */
    void setAcadamicStatus(Character acadamicStatus) {
        this.acadamicStatus = acadamicStatus;
    }

    /**
     * School getter for lecturer.
     * @return name of school as string.
     */
    public String getSchool() {
        return this.school;
    }
    /**
     * Acadamic status getter for lecturer.
     * @return acadamic status as character.
     */
    public Character getAcadamicStatus() {
        return this.acadamicStatus;
    }

    @Override
    public String toString() {
        String msg = Roger.toString() + ", worked in " + this.getSchool() + 
        " with acadamic status " + this.getAcadamicStatus();
        return msg;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) { return false; }
        if (this.getClass() != obj.getClass()) {
            return false;
        }

        Lecturer other = (Lecturer) obj;
        if (this.Roger.equals(other.Roger) &&
            other.school.equals(this.school) &&
            other.acadamicStatus.equals(this.acadamicStatus)) {
            return true;
        }
        else {
            return false;
        }
    }

}
