package global.bizdevelope.realmapay.service;

import global.bizdevelope.realmapay.domain.Approved;
import global.bizdevelope.realmapay.domain.ApprovedRepository;
import global.bizdevelope.realmapay.domain.PayRequest;
import global.bizdevelope.realmapay.domain.PayRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

public class ApproveService {

    @Autowired
    ApprovedRepository approvedRepository;

    @Autowired
    PayRequestRepository payRequestRepository;


    public List<Approved> findAll(){
        List<Approved> approvedList = new ArrayList<>();
        approvedRepository.findAll().forEach(e -> approvedList.add(e));
        return approvedList;
    }

    public boolean isApproved(@RequestBody PayRequest payRequest){
        Boolean isApproved = false;

        try{
            payRequestRepository.findByReservationId(payRequest.getReservationId());
        }catch (Exception e){
            isApproved=false;
        }
        return isApproved;
    }

    public boolean paymentReq(@RequestBody PayRequest payRequest){

        Approved approved = new Approved();
        approved.setCustomerId(payRequest.getCustomerId());
        approved.setReservationId(payRequest.getReservationId());
        if(payRequest.isBalance()){
            approvedRepository.save(approved);
            return true;
        }
        return false;
    }

}
