package africa.semicolon.hostelManagementSystem.services;

import africa.semicolon.hostelManagementSystem.dto.requests.MakePaymentRequest;
import africa.semicolon.hostelManagementSystem.dto.requests.RegisterAsOccupantRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
public class OccupantServiceImplTest {
    @Autowired
    private OccupantService occupantService;
    @Autowired
    private UserService userService;
@Test
public void testThatOccupantCanMakePayment(){
    registerWinnie();
    MakePaymentRequest makePaymentRequest = new MakePaymentRequest();
    occupantService.makePayment(makePaymentRequest);
    assertTrue(occupantService.hasPaid("disney@mail.com"));

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
}