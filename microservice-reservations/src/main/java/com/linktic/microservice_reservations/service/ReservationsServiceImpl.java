package com.linktic.microservice_reservations.service;

import com.linktic.microservice_reservations.dto.ReservationFiltersDTO;
import com.linktic.microservice_reservations.entities.Reservation;
import com.linktic.microservice_reservations.repository.IReservationRepository;
import com.linktic.microservice_reservations.repository.IReservationRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationsServiceImpl implements IReservationService {

    @Autowired
    private IReservationRepository reservationRepository;
    @Autowired
    private IReservationRepositoryCustom reservationRepositoryCustom;
    @Override
    public List<Reservation> findAll() {
        return (List<Reservation>) reservationRepository.findAll();
    }

    @Override
    public Reservation findById(Long id) {
        return reservationRepository.findById(id).orElseThrow();
    }

    @Override
    public void save(Reservation reservation) {
        reservationRepository.save(reservation);
    }

    @Override
    public Reservation update(Reservation reservation) {

        Optional<Reservation> reservationInDB = reservationRepository.findById(reservation.getId());

        if (reservationInDB.isPresent()) {
            Reservation reservationUpdated = reservationInDB.get();
            reservationUpdated.setUserId(reservation.getUserId());
            reservationUpdated.setServiceId(reservation.getServiceId());
            reservationUpdated.setStartDate(reservation.getStartDate());
            reservationUpdated.setStatus(reservation.getStatus());

            return reservationRepository.save(reservationUpdated);
        } else {
            throw new RuntimeException("Reservation with id: " + reservation.getId() +" not found");
        }
    }

    @Override
    public List<Reservation> findReservationByFilters(ReservationFiltersDTO filters) {
        return reservationRepositoryCustom.findReservationByFilters(filters);
    }
}
