package africa.semicolon.hostelManagementSystem.services;

import africa.semicolon.hostelManagementSystem.dto.requests.RegisterUserRequest;
import africa.semicolon.hostelManagementSystem.dto.responses.RegisterUserResponse;

public interface UserService {
    RegisterUserResponse createUser (RegisterUserRequest request);
}
