package global.bizdevelope.realmanapp.service;

import global.bizdevelope.realmanapp.domain.Reservation;
import global.bizdevelope.realmanapp.domain.User;
import global.bizdevelope.realmanapp.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> findAll(){
        List<Reservation> reservations = new ArrayList<>();
        reservationRepository.findAll().forEach(e -> reservations.add(e));
        return reservations;
    }

    public void reserve(@RequestBody Reservation reservation){
        Reservation newReservation = reservationRepository.save(reservation);
    }



}
