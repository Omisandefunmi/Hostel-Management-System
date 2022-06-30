package africa.semicolon.hostelManagementSystem.dto.requests;

import africa.semicolon.hostelManagementSystem.data.model.Role;
import lombok.Data;

@Data
public class RegisterUserRequest {
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private Role role;

}
