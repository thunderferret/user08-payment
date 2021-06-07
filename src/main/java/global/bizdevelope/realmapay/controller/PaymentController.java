package global.bizdevelope.realmapay.controller;


import global.bizdevelope.realmapay.domain.PayRequest;
import global.bizdevelope.realmapay.service.ApproveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController("/payment")
public class PaymentController {


    private ApproveService approveService;

    @GetMapping("/payment/test")
    public String test(){
        return "Hello MSA";
    }

    @GetMapping("/customerlist")
    public List getAllCustomerList(HttpServletRequest req){
        return approveService.findAll();
    }

    @PostMapping("/approverequest")
    public void approveRequest(HttpServletRequest req){
        PayRequest payRequest = new PayRequest();
        payRequest.setBalance(true);
        payRequest.setCustomerId("TEST Customer ID");
        payRequest.setReservationId("Test Reservation Id");
        approveService.paymentReq(payRequest);
    }



    /*
    @GetMapping("/payment/customerlist")
    public List getAllCustomerList(HttpServletRequest req){
        return service.findAll();
    }

    @PostMapping("/reservationreq")
    public String reservation(@ModelAttribute User user){


        System.out.println(user);


        Reservation reservation = new Reservation();
        reservation.setCustomerName(user.getCustomerName());
        reservation.setCustomerId(user.getUserId());
        service.reserve(reservation);
        return "User Request Accepted";
    }
*/
}
