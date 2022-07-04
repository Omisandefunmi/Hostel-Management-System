package africa.semicolon.hostelManagementSystem.data.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("Beds")
public class Bed {
    private boolean isOccupied;
    private Occupant OccupantName;


}
