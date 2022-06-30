package africa.semicolon.hostelManagementSystem.utils;

import africa.semicolon.hostelManagementSystem.data.model.User;
import africa.semicolon.hostelManagementSystem.dto.requests.RegisterUserRequest;
import africa.semicolon.hostelManagementSystem.dto.responses.RegisterUserResponse;

public class Mapper {
    public static void map(User user, RegisterUserRequest request) {
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setUsername(request.getUserName());
        user.setPassword(request.getPassword());
        user.setRole(request.getRole());
    }

    public static void map(User user, RegisterUserResponse response) {
        response.setUserName(user.getUsername());
    }
}
