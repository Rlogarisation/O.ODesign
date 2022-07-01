package programmingexample1;

import java.util.List;

public class Hotel {
    private List allRooms;
    private String hotelName;
    
    public Hotel(String nameOfHotel) {}

    // Hotel Managers can add a room to their hotel. 
    // Rooms have a room number, and size (small, medium or large).
    public void addRoom(int roomNumber, String size) {}

    // Hotel Managers can display the occupancy of all rooms at the specified hotel in order of room creation, then booking start date.
    public List displayAllRooms() {
        return allRooms;
    }
}
