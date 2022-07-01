package programmingexample1;

import java.time.LocalDate;

public class Request {
    private String nameOfCustomer;
    private LocalDate startingDate, checkoutDate;
    private String sizeOfRoom; 

    public Request(LocalDate start, LocalDate end, String size) {}


    // A booking/change request is either granted in full or is completely rejected by the system (a request cannot be partially fulfilled).
    public boolean requestCheck() {
        return true;
    }

    // Request can be cancelled during to change, cancellation.
    public void cancelRequest(){}
}
