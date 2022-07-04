package africa.semicolon.hostelManagementSystem.controller;

import africa.semicolon.hostelManagementSystem.dto.requests.RegisterAsOccupantRequest;
import africa.semicolon.hostelManagementSystem.dto.responses.ApiResponse;
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

    @PostMapping("/createOccupant")
    public ResponseEntity <?> createOccupant(@RequestBody RegisterAsOccupantRequest request){
        try{
            var serviceResponse = userService.registerAsOccupant(request);
            ApiResponse apiResponse = new ApiResponse(true, serviceResponse);
            return  new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
        }catch (Exception ex){
            ApiResponse apiResponse = new ApiResponse(false, ex.getMessage());
            return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
        }
    }

//    public ResponseEntity <?> login(@RequestBody LogInUserRequest request){}

}
