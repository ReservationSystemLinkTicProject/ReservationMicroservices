package com.linktic.microservice_reservations.exception;

public class ReservationNotFoundException extends RuntimeException {
    public ReservationNotFoundException(Long reservationId) {
        super("Reservation with id: " + reservationId + " not found");
    }
}
