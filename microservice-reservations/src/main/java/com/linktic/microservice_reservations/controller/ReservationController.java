package com.linktic.microservice_reservations.controller;

import com.linktic.microservice_reservations.dto.ReservationDTO;
import com.linktic.microservice_reservations.dto.ReservationFiltersDTO;
import com.linktic.microservice_reservations.entities.Reservation;
import com.linktic.microservice_reservations.entities.ReservationStatus;
import com.linktic.microservice_reservations.service.IReservationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/api/reservations")
@Validated
public class ReservationController {

    @Autowired
    private IReservationService reservationService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveReservation(@Valid @RequestBody ReservationDTO reservation) {
        reservationService.save(reservation);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> updateReservation(@PathVariable Long id, @Valid @RequestBody ReservationDTO reservation) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        Reservation reservationEntity = new Reservation();
        reservationEntity.setId(id);
        reservationEntity.setUserId(reservation.getUserId());
        reservationEntity.setServiceId(reservation.getServiceId());
        reservationEntity.setStartDate(LocalDateTime.parse(reservation.getStartDate(), formatter));
        reservationEntity.setEndDate(LocalDateTime.parse(reservation.getEndDate(), formatter));
        reservationEntity.setStatus(ReservationStatus.valueOf(reservation.getStatus()));
        return ResponseEntity.ok(reservationService.update(reservationEntity));
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(reservationService.findAll());
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return ResponseEntity.ok(reservationService.findById(id));
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/filters")
    public ResponseEntity<?> findReservationByFilters(@RequestParam(required = false) Long userId,
                                                      @RequestParam(required = false) Long serviceId,
                                                      @RequestParam(required = false) String startDate,
                                                      @RequestParam(required = false) String endDate,
                                                      @RequestParam(required = false) String status) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        ReservationFiltersDTO filters = new ReservationFiltersDTO();

        if (userId != null) {
            filters.setUserId(userId);
        }

        if (serviceId != null) {
            filters.setServiceId(serviceId);
        }

        if (status != null) {
            filters.setStatus(status);
        }

        if (startDate != null && !startDate.isEmpty()) {
            filters.setStartDate(LocalDateTime.parse(startDate, formatter));
        }

        if (endDate != null && !endDate.isEmpty()) {
            filters.setEndDate(LocalDateTime.parse(endDate, formatter));
        }

        return ResponseEntity.ok(reservationService.findReservationByFilters(filters));
    }
}
