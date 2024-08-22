package com.linktic.microservice_reservations.repository;

import com.linktic.microservice_reservations.entities.Reservation;
import org.springframework.data.repository.CrudRepository;

public interface IReservationRepository extends CrudRepository<Reservation, Long> {
}
