package programmingexample2;

import java.time.LocalDate;
import java.util.List;

public class Flight {
    private List<Passenger> onboardPassengers;
    private List<Boolean> seats;
    private LocalDate flightDate;
    private String flightName;

    /**
     * Constructor for flight
     * @param date the date of flight
     * @param name the name of flight
     */
    public Flight(LocalDate date, String name) {}

    public boolean isSeatAvailable(String flightClass, String flightSeat) {
        return true;
    }

    public boolean addPassenger(Passenger customer, String selectedClass, String seatChoice) {
        return true;
    }

    public boolean removePassenger(Passenger customer) {return true;}

    public boolean updateSeat(Passenger customer, String selectedClass, String newSeatChoice) {
        return true;
    }
    


}
