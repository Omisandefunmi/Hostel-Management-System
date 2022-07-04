package africa.semicolon.hostelManagementSystem.services;

import africa.semicolon.hostelManagementSystem.data.model.Occupant;
import africa.semicolon.hostelManagementSystem.dto.requests.MakePaymentRequest;
import africa.semicolon.hostelManagementSystem.dto.responses.MakePaymentResponse;

public interface OccupantService {

    MakePaymentResponse makePayment(MakePaymentRequest request);

    boolean hasPaid(String occupantEmail);
}
