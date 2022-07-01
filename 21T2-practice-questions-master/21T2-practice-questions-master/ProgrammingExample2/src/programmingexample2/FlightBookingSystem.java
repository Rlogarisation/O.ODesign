package programmingexample2;

import java.time.LocalDate;
import java.util.List;

public class FlightBookingSystem {
    private List<Flight> listOfFlight;
    private List<Passenger> listOfPassengers;

    public void creatingFlight(LocalDate departure, LocalDate arrival, String name) {}

    public void createPassenger(String name) {}

    public void bookFlight(Passenger customer, Flight selectedFlight, String selectedClass, String seatChoice) {}

    public boolean changeFlight(Passenger customer, Flight oldFlight, Flight newFlight, String selectedClass, String seatChoice) {return true;}

    public boolean cancelFlight(Passenger customer, Flight selectedFlight) {return true;}

    public boolean updateSeat(Passenger customer, Flight selectedFlight, String selectedClass, String newSeatChoice) {return true;}
    public static void main(String[] args) {}
}
