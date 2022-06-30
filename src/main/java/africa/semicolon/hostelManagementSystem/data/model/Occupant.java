package africa.semicolon.hostelManagementSystem.data.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
public class Occupant extends User {
    private int roomNumber;
    private StayDuration stayDuration;
    private boolean occupancyValidityStatus;

}
