package africa.semicolon.hostelManagementSystem.dto.requests;

import africa.semicolon.hostelManagementSystem.data.model.PaymentType;
import lombok.Data;

@Data
public class MakePaymentRequest {
    private double amount;
    private String occupantEmail;
    //room number?

}
