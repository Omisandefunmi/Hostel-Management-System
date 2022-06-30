package africa.semicolon.hostelManagementSystem.controller;

import africa.semicolon.hostelManagementSystem.dto.requests.RegisterUserRequest;
import africa.semicolon.hostelManagementSystem.dto.responses.RegisterUserResponse;
import africa.semicolon.hostelManagementSystem.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/createUser")
    public ResponseEntity <?> createUser(@RequestBody RegisterUserRequest request){
        try{
            return  new ResponseEntity<>(userService.createUser(request), HttpStatus.CREATED);
        }catch (Exception ex){
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
