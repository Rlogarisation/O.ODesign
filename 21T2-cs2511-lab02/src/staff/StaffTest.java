package staff;

public class StaffTest {
    static void printStaffDetails(Object staff) {
        System.out.println(staff.toString());
    }

    public static void main(String[] args) {
        StaffMember staffA = new StaffMember("Alden", 10000.3, 20101001, 20201001);
        Lecturer lecturerB = new Lecturer("Briden", 20000.2, 20101001, 20201010, "CSE", 'A');
        printStaffDetails(staffA);
        printStaffDetails(lecturerB);

        // staff A should equal to C.
        StaffMember staffC = staffA;
        Lecturer lecturerE = lecturerB;
        // staff D would not equal to staffD, even though all info are equal.
        // But the address is different.
        StaffMember staffD = new StaffMember("Alden", 10000.3, 20101001, 20201001);
        Lecturer lecturerF = new Lecturer("Briden", 20000.2, 20101001, 20201010, "CSE", 'A');

        System.out.println(staffA.equals(staffC));
        System.out.println(lecturerB.equals(lecturerE));

        System.out.println(staffA.equals(staffD));
        System.out.println(lecturerB.equals(lecturerF));
    }
}
