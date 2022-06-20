package africa.semicolon.hostelManagementSystem.data.model;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor

public class Room {
    private int roomNumber;
    private Occupant[] occupantsInRoom;
    @NonNull
    private Bed[] beds;
    @NonNull
    private int numberOfBeds;
    private int occupiedBedSpace;

    public Room(int numberOfBeds){
        this.numberOfBeds = numberOfBeds;
        this.beds = new Bed[numberOfBeds];
        this.occupantsInRoom = new Occupant[beds.length];
    }

}
