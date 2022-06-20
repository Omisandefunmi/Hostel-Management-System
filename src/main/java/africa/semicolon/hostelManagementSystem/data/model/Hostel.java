package africa.semicolon.hostelManagementSystem.data.model;

import lombok.Data;

@Data
public class Hostel {
    private Room[] rooms;
    private Occupant[] occupants;

}
