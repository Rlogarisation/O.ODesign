package part3q1;

import java.time.LocalDate;
import java.util.ArrayList;

public class ConferenceBookingSystem {
    // List of all rooms in list.
    private ArrayList<Room> listOfRooms;
    // The id value of the next booking (initially >= 0). This is incremented after
    // each booking to ensure each booking has a unique id and is positive.
    private int nextBookingId = 0;


    /**
     * Constructor for conferecne booking system, by setting up all rooms.
     */
    public ConferenceBookingSystem() {}

    /**
     * Create rooms with name, id, and certain capacity.
     * @param name
     * @param id
     * @param capacity
     */
    public void createRooms(String name, int id, int capacity) {}
    
    /**
     * Bookings can be made for either a single room or multiple rooms 
     * The bookings have a start date and time and an end date and time 
     * When the booking is created, the number of people in the conference is specified.
     * @param NumberOfRooms
     * @param startDate
     * @param endDate
     * @param NumberOfAttendee
     * @return The status of booking.
     */
    public boolean bookingRoom(int NumberOfRooms, LocalDate startDate, LocalDate endDate, int NumberOfAttendee) {return true;}

    /**
     * A booking should be able to be cancelled by entering followed inputs
     * @param NumberOfRooms
     * @param startDate
     * @param endDate
     * @return the status of cancellation.
     */
    public boolean cancelBooking(int NumberOfRooms, LocalDate startDate, LocalDate endDate) {return true;}

    /**
     * A room cannot be booked out at the same time by two bookings
     * If the number of people in the conference exceeds the total room capacity, the booking fails
     * @param startDate
     * @param endDate
     * @param NumberOfAttendee
     * @return the status of booking
     */
    public boolean roomAvailbilityCheck(LocalDate startDate, LocalDate endDate, int NumberOfAttendee) {return true;}

    

    public static void main(String[] args) {}

}