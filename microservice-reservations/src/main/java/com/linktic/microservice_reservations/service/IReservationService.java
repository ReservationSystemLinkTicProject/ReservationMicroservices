package com.linktic.microservice_reservations.service;

import com.linktic.microservice_reservations.dto.ReservationDTO;
import com.linktic.microservice_reservations.dto.ReservationFiltersDTO;
import com.linktic.microservice_reservations.entities.Reservation;

import java.util.List;


public interface IReservationService {
    List<Reservation> findAll();
    Reservation findById(Long id);
    void save(ReservationDTO reservation);
    Reservation update(Reservation reservation);
    List<Reservation> findReservationByFilters(ReservationFiltersDTO filters);
}
