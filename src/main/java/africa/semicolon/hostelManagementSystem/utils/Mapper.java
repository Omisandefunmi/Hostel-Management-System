package africa.semicolon.hostelManagementSystem.utils;

import africa.semicolon.hostelManagementSystem.data.model.Role;
import africa.semicolon.hostelManagementSystem.data.model.User;
import africa.semicolon.hostelManagementSystem.data.model.Visitor;
import africa.semicolon.hostelManagementSystem.dto.requests.RegisterAsAdminRequest;
import africa.semicolon.hostelManagementSystem.dto.requests.RegisterAsOccupantRequest;
import africa.semicolon.hostelManagementSystem.dto.requests.RegisterAsVisitorRequest;
import africa.semicolon.hostelManagementSystem.dto.responses.LogInUserResponse;
import africa.semicolon.hostelManagementSystem.dto.responses.RegisterAsAdminResponse;
import africa.semicolon.hostelManagementSystem.dto.responses.RegisterAsOccupantResponse;
import africa.semicolon.hostelManagementSystem.dto.responses.RegisterAsVisitorResponse;
import com.google.common.base.Enums;

public class Mapper {
    public static void map(RegisterAsOccupantRequest request, User user) {
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setUsername(request.getUserName());
        user.setPassword(request.getPassword());
        user.setEmail(request.getEmail());
//        if(getIfPresent())
        user.setRole(Role.OCCUPANT);


//        switch (request.getRole().toLowerCase()) {
//            case "admin" -> user.setRole(Role.ADMIN);
//            case "occupant" -> user.setRole(Role.OCCUPANT);
//            case "visitor" -> user.setRole(Role.VISITOR);
//            default -> throw new HostelManagementException("No such user exist");
//        }

    }

    public static void map(User user, RegisterAsOccupantResponse response) {
        response.setUserName(user.getUsername());
        response.setMessage(response.getUserName()+" is now an Occupant");
    }

    public static void map(User user, LogInUserResponse response) {
        response.setFirstName(user.getFirstName());
        response.setLastName(user.getLastName());
    }

    private static Role getIfPresent(String role) {
        return Enums.getIfPresent(Role.class, role.toUpperCase()).orNull();
    }

    public static void map(RegisterAsAdminRequest request, User user) {
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setUsername(request.getUserName());
        user.setPassword(request.getPassword());
        user.setRole(Role.ADMIN);
    }

    public static void map(User savedUser, RegisterAsAdminResponse response) {
        response.setUserName(savedUser.getUsername());
        response.setMessage(response.getUserName()+"'s created as an Admin");
    }


    public static void map(RegisterAsVisitorRequest request, User user) {
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setRole(Role.VISITOR);
    }

    public static void map(RegisterAsVisitorRequest request, Visitor visitor) {
        visitor.setFirstName(request.getFirstName());
        visitor.setLastName(request.getLastName());
        visitor.setHostName(request.getHostName());
        visitor.setTimeIn(request.getTimeIn());

    }

    public static void map(Visitor savedVisitor, RegisterAsVisitorResponse response) {
        response.setName(savedVisitor.getFirstName()+ " "+ savedVisitor.getLastName());
        response.setMessage("Welcome");
    }
}
