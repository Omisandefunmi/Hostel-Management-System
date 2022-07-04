package africa.semicolon.hostelManagementSystem.data.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
@Data
@NoArgsConstructor
public class Visitor {
    private String firstName;
    private String lastName;
    private String visitorIdNumber;
    private String visitingRoomNumber;
    private String hostName;
    private LocalDateTime timeIn;
    private LocalDateTime timeOut;

}
