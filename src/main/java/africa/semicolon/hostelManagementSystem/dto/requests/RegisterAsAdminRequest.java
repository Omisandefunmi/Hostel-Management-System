package africa.semicolon.hostelManagementSystem.dto.requests;

import lombok.Data;

@Data
public class RegisterAsAdminRequest {
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String email;
}
