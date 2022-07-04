package africa.semicolon.hostelManagementSystem.data.model;

import lombok.Data;
@Data
public class Occupant extends User {
    private String roomNumber;
    private StayDuration stayDuration;
//    private boolean occupancyValidityStatus = false;
//    private boolean paymentStatus = false;
}
