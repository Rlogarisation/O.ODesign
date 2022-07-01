package satellite;


public class Satellite {
    
    /**
     * Constructor for Satellite
     * @param name
     * @param height
     * @param velocity
     */
    private String name;
    private int height;
    private double velocity;
    private double position;


    public Satellite(String name, int height, double position, double velocity) {
        this.setName(name);
        this.setHeight(height);
        this.setPosition(position);
        this.setVelocity(velocity);

    }

    /**
     * Getter for name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Getter for height
     */
    public int getHeight() {
        return this.height;
    }

    /**
     * Getter for position (degrees)
     */
    public double getPositionDegrees() {
        return this.position;
    }

    /**
     * Getter for position (radians)
     */
    public double getPositionRadians() {
        return Math.toRadians(getPositionDegrees());
    }

    /**
     * Returns the linear velocity (metres per second) of the satellite
     */
    public double getLinearVelocity() {
        return this.velocity;
    }

    /**
     * Returns the angular velocity (degrees per second) of the satellite
     */
    // angular velocity = linear velocity / radius
    public double getAngularVelocity() {
        return getLinearVelocity() / getHeight();
    }

    /**
     * Setter for name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Setter for height
     * @param height
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * Setter for velocity
     * @param velocity
     */
    public void setVelocity(double velocity) {
        this.velocity = velocity;
    }

    /**
     * Setter for position
     * @param position
     */
    public void setPosition(double position) {
        this.position = position;
    }

    /**
     * Calculates the distance travelled by the satellite in the given time
     * @param time (seconds)
     * @return distance in metres
     */

    public double distance(double time) {
        return getLinearVelocity() * time;
    }


    public static void main(String[] args) {
        // Satellite(String name, int height, double position, double velocity)
        Satellite A = new Satellite("Satellite A", 10000 * 1000, 122, 55);
        Satellite B = new Satellite("Satellite B", 5438 * 1000, 0, 234 * 1000);
        Satellite C = new Satellite("Satellite C", 9029 * 1000, 284, 0);

        System.out.println("I am " + A.getName() + " at position " + A.getPositionDegrees() + 
        " degrees, " + A.getHeight() + " km above the centre of the earth and moving at a velocity of " + 
        A.getLinearVelocity() + " metres per second");
        // Change Satellite A's height to 9999
        A.setHeight(9999);
        // Change Satellite B's angle to 45
        B.setPosition(45);
        // Change Satellite C's velocity to 36.5 mps
        C.setVelocity(36.5);
        // Print out Satellite A's position in radians
        System.out.println(A.getPositionRadians());
        // Print out Satellite B's angular velocity
        System.out.println(B.getAngularVelocity());
        // Print out the distance Satellite C travels after 2 minutes.
        System.out.println(C.getAngularVelocity() * C.getHeight() * 2 * 60);

    } 

}