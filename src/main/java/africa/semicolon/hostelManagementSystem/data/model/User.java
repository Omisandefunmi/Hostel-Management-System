package africa.semicolon.hostelManagementSystem.data.model;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@Document("Users")
public class User {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String username;
    private Role role;
    private String email;
    private String password;
}
