package africa.semicolon.hostelManagementSystem.services;

import africa.semicolon.hostelManagementSystem.data.model.User;
import africa.semicolon.hostelManagementSystem.data.repositories.UserRepository;
import africa.semicolon.hostelManagementSystem.dto.requests.MakePaymentRequest;
import africa.semicolon.hostelManagementSystem.dto.responses.MakePaymentResponse;
import africa.semicolon.hostelManagementSystem.exceptions.HostelManagementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class OccupantServiceImpl implements OccupantService{
@Autowired
private UserService userService;
@Autowired
private UserRepository userRepository;
    @Override
    public MakePaymentResponse makePayment(MakePaymentRequest request) {
        User user = userService.findUserByEmail(request.getOccupantEmail()).orElseThrow(() -> new HostelManagementException("invalid email"));

        return null;
    }

    @Override
    public boolean hasPaid(String occupantEmail) {
        return false;
    }
}
