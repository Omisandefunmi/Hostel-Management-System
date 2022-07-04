package africa.semicolon.hostelManagementSystem.dto.requests;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class RegisterAsVisitorRequest {
    private String firstName;
    private String lastName;
    private String visitingRoomNumber;
    private String hostName;
    private LocalDateTime timeIn = LocalDateTime.now();
}
