package africa.semicolon.hostelManagementSystem.services;

import africa.semicolon.hostelManagementSystem.data.model.User;
import africa.semicolon.hostelManagementSystem.data.model.Visitor;
import africa.semicolon.hostelManagementSystem.data.repositories.UserRepository;
import africa.semicolon.hostelManagementSystem.dto.requests.LogInUserRequest;
import africa.semicolon.hostelManagementSystem.dto.requests.RegisterAsAdminRequest;
import africa.semicolon.hostelManagementSystem.dto.requests.RegisterAsVisitorRequest;
import africa.semicolon.hostelManagementSystem.dto.responses.RegisterAsAdminResponse;
import africa.semicolon.hostelManagementSystem.dto.requests.RegisterAsOccupantRequest;
import africa.semicolon.hostelManagementSystem.dto.responses.LogInUserResponse;
import africa.semicolon.hostelManagementSystem.dto.responses.RegisterAsOccupantResponse;
import africa.semicolon.hostelManagementSystem.dto.responses.RegisterAsVisitorResponse;
import africa.semicolon.hostelManagementSystem.exceptions.LogInUserException;
import africa.semicolon.hostelManagementSystem.exceptions.RegisterOccupantException;
import africa.semicolon.hostelManagementSystem.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;
    @Autowired
    VisitorService visitorService;

    @Override

    public RegisterAsOccupantResponse registerAsOccupant(RegisterAsOccupantRequest request) {
       Optional<User> foundUser =  userRepository.findByEmail(request.getEmail());

       if (foundUser.isPresent()) {
           throw new RegisterOccupantException(request.getEmail()+" is already an occupant");
       }

        User user = new User();
        Mapper.map(request, user);

        User savedUser = userRepository.save(user);
        RegisterAsOccupantResponse response = new RegisterAsOccupantResponse();
        Mapper.map(savedUser, response);

        return response;
    }
    @Override
    public RegisterAsAdminResponse registerAsAdmin(RegisterAsAdminRequest request){
        User user = new User();
        Mapper.map(request, user);

        User savedUser = userRepository.save(user);
        RegisterAsAdminResponse response = new RegisterAsAdminResponse();
        Mapper.map(savedUser, response);

        return response;
    }
    @Override
    public LogInUserResponse login(LogInUserRequest request){
        User user = userRepository.findByEmail(request.getEmail()).orElseThrow(() -> new LogInUserException(request.getEmail()+" does not exists"));
        LogInUserResponse response = new LogInUserResponse();
        if(user.getPassword().equals(request.getPassword())){
            Mapper.map(user, response);
        }
        return response;
    }

    @Override
    public RegisterAsVisitorResponse registerAsVisitor(RegisterAsVisitorRequest request) {
        User user = new User();
        Mapper.map(request, user);
        userRepository.save(user);

        Visitor visitor = new Visitor();
        Mapper.map(request, visitor);
        Visitor savedVisitor = visitorService.save(visitor);

        RegisterAsVisitorResponse response = new RegisterAsVisitorResponse();
        Mapper.map(savedVisitor, response);
        return response;
    }

    @Override
    public Optional<User> findUserByEmail(String occupantEmail) {
        return userRepository.findByEmail(occupantEmail);
    }

}
