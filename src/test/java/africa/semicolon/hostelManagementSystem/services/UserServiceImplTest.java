package africa.semicolon.hostelManagementSystem.services;

import africa.semicolon.hostelManagementSystem.data.repositories.UserRepository;
import africa.semicolon.hostelManagementSystem.data.repositories.VisitorRepository;
import africa.semicolon.hostelManagementSystem.dto.requests.RegisterAsAdminRequest;
import africa.semicolon.hostelManagementSystem.dto.requests.RegisterAsOccupantRequest;
import africa.semicolon.hostelManagementSystem.dto.requests.RegisterAsVisitorRequest;
import africa.semicolon.hostelManagementSystem.exceptions.RegisterOccupantException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserServiceImplTest {
    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;

    @Autowired
    VisitorRepository visitorRepository;
    @Test
    public void testThatAdminCanCreateAccount(){
        RegisterAsAdminRequest request = new RegisterAsAdminRequest();
        request.setFirstName("Winnie");
        request.setLastName("Pooh");
        request.setUserName("winnie d pooh");
        request.setEmail("disney@mail.com");
        request.setPassword("1111");

        userService.registerAsAdmin(request);
        assertEquals(1, userRepository.count());
    }

    @Test
    public void testThatOccupantCanCreated(){
        registerWinnie();
        assertEquals(1, userRepository.count());
    }

    private void registerWinnie() {
        RegisterAsOccupantRequest request = new RegisterAsOccupantRequest();
        request.setFirstName("Winnie");
        request.setLastName("Pooh");
        request.setUserName("winnie d pooh");
        request.setEmail("disney@mail.com");
        request.setPassword("1111");

        userService.registerAsOccupant(request);
    }

    @Test
    public void testThatVisitorsCanBeCreated(){
        RegisterAsVisitorRequest request = new RegisterAsVisitorRequest();
        request.setHostName("winnie");
        request.setFirstName("moon");
        request.setLastName("sun");
        request.setVisitingRoomNumber("1");

        userService.registerAsVisitor(request);
        assertEquals(1, visitorRepository.count());
        assertEquals(1, userRepository.count());


    }
    @Test
    public void testThatUserCantRegisterSameEmail(){
       registerWinnie();
        assertThrows(RegisterOccupantException.class, this::registerWinnie);
    }

    @Test
    public void testThatAdminCanAllocateRooms(){
        registerWinnie();
    }


}