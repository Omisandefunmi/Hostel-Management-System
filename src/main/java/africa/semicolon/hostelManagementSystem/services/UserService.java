package africa.semicolon.hostelManagementSystem.services;

import africa.semicolon.hostelManagementSystem.data.model.User;
import africa.semicolon.hostelManagementSystem.dto.requests.LogInUserRequest;
import africa.semicolon.hostelManagementSystem.dto.requests.RegisterAsAdminRequest;
import africa.semicolon.hostelManagementSystem.dto.requests.RegisterAsOccupantRequest;
import africa.semicolon.hostelManagementSystem.dto.requests.RegisterAsVisitorRequest;
import africa.semicolon.hostelManagementSystem.dto.responses.LogInUserResponse;
import africa.semicolon.hostelManagementSystem.dto.responses.RegisterAsAdminResponse;
import africa.semicolon.hostelManagementSystem.dto.responses.RegisterAsOccupantResponse;
import africa.semicolon.hostelManagementSystem.dto.responses.RegisterAsVisitorResponse;

import java.util.Optional;

public interface UserService {
    RegisterAsOccupantResponse registerAsOccupant(RegisterAsOccupantRequest request);
    RegisterAsAdminResponse registerAsAdmin(RegisterAsAdminRequest request);
    LogInUserResponse login(LogInUserRequest request);

    RegisterAsVisitorResponse registerAsVisitor(RegisterAsVisitorRequest request);

    Optional<User> findUserByEmail(String occupantEmail);
}
