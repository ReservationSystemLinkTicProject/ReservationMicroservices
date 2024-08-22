package com.linktic.microservice_reservations.repository;

import com.linktic.microservice_reservations.dto.ReservationFiltersDTO;
import com.linktic.microservice_reservations.entities.Reservation;

import java.util.List;

public interface IReservationRepositoryCustom {
    List<Reservation> findReservationByFilters(ReservationFiltersDTO filters);
}
