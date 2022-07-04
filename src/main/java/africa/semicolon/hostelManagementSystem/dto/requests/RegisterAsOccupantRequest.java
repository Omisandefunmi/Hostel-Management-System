package africa.semicolon.hostelManagementSystem.dto.requests;

import lombok.Data;

@Data
public class RegisterAsOccupantRequest {
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String email;

}
