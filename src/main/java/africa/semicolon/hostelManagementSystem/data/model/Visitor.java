package africa.semicolon.hostelManagementSystem.data.model;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
@Data
@RequiredArgsConstructor
public class Visitor {
    @NonNull
    private String name;
    private int visitorIdNumber;


    @NonNull
    private int visitingRoomNumber;
    @NonNull
    private String hostName;

    @NonNull
    private LocalDateTime timeIn;
    private LocalDateTime timeOut;

}
