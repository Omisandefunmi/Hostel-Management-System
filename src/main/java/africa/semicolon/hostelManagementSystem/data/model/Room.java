package africa.semicolon.hostelManagementSystem.data.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@RequiredArgsConstructor
@NoArgsConstructor

public class Room {
    @Id
    private String id;
    private String roomNumber;
    @NonNull
    private Bed[] beds;
    @NonNull
    private int numberOfBeds;
    private int occupiedBedSpace;

    public Room(int numberOfBeds){
        this.numberOfBeds = numberOfBeds;
        this.beds = new Bed[numberOfBeds];
        for (int i = 0; i <beds.length ; i++) {
            beds[i] = new Bed();
        }
    }

}
