package africa.semicolon.hostelManagementSystem.data.model;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Occupant {
    @NonNull
    private String lastName;
    @NonNull
    private String firstName;
    private String OccupantId;
    private Room room;
    private int roomNumber;
    @NonNull
    private StayDuration stayDuration;
    private boolean occupancyValidityStatus;

}
