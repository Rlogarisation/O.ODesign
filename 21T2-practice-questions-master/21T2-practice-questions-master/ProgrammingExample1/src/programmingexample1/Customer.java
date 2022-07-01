package programmingexample1;

import java.time.LocalDate;

public class Customer {
    private String nameOfCustomer;
    private LocalDate startingDate, checkoutDate;
    private String sizeOfRoom; 


    public Customer(String name) {}

    // Booking requests have a request number (each booking request has a unique request number), 
    // starting date, checkout date, and request for 1 room of a single size (small, medium or large)
    public Request booking() {
        return new Request(startingDate, checkoutDate, sizeOfRoom);
    }

    // Booking changes have the request number of the booking to be changed, 
    // and the new starting date, checkout date, 
    // and request for 1 room of a single size (small, medium or large).
    public Request changeBooking(LocalDate newStartingTime, LocalDate newEndingTime, String newRoomSize) {
        return new Request(newStartingTime, newEndingTime, newRoomSize);
    }

    // Customers can cancel a booking by providing the request number of the booking.
    public void cancelBooking(Request bookingNumber) {}
}
