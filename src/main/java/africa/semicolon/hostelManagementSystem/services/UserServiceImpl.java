package africa.semicolon.hostelManagementSystem.services;

import africa.semicolon.hostelManagementSystem.data.model.User;
import africa.semicolon.hostelManagementSystem.data.repositories.UserRepository;
import africa.semicolon.hostelManagementSystem.dto.requests.RegisterUserRequest;
import africa.semicolon.hostelManagementSystem.dto.responses.RegisterUserResponse;
import africa.semicolon.hostelManagementSystem.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public RegisterUserResponse createUser(RegisterUserRequest request) {
        User user = new User();
        Mapper.map(user, request);
        User savedUser = userRepository.save(user);
        RegisterUserResponse response = new RegisterUserResponse();
        Mapper.map(savedUser, response);

        return response;
    }
}
