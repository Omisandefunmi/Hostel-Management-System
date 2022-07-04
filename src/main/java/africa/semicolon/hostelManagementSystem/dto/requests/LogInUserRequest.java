package africa.semicolon.hostelManagementSystem.dto.requests;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LogInUserRequest {
    private String email;
    private String password;
    private String role;
}
