package com.linktic.microservice_reservations.service;

import com.linktic.microservice_reservations.client.IServiceClient;
import com.linktic.microservice_reservations.client.IUserClient;
import com.linktic.microservice_reservations.dto.ReservationDTO;
import com.linktic.microservice_reservations.dto.ReservationFiltersDTO;
import com.linktic.microservice_reservations.entities.Reservation;
import com.linktic.microservice_reservations.entities.ReservationStatus;
import com.linktic.microservice_reservations.exception.ReservationNotFoundException;
import com.linktic.microservice_reservations.repository.IReservationRepository;
import com.linktic.microservice_reservations.repository.IReservationRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationsServiceImpl implements IReservationService {

    @Autowired
    private IReservationRepository reservationRepository;
    @Autowired
    private IReservationRepositoryCustom reservationRepositoryCustom;
    @Autowired
    private IUserClient userClient;
    @Autowired
    private IServiceClient serviceClient;

    @Override
    public List<Reservation> findAll() {
        return (List<Reservation>) reservationRepository.findAll();
    }

    @Override
    public Reservation findById(Long id) {
        return reservationRepository.findById(id).orElseThrow(() -> new ReservationNotFoundException(id));
    }

    @Override
    public void save(ReservationDTO reservation) {
        userClient.findById(reservation.getUserId());
        serviceClient.findById(reservation.getServiceId());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Reservation reservationEntity = new Reservation();
        reservationEntity.setUserId(reservation.getUserId());
        reservationEntity.setServiceId(reservation.getServiceId());
        reservationEntity.setStartDate(LocalDate.parse(reservation.getStartDate(), formatter));
        reservationEntity.setEndDate(LocalDate.parse(reservation.getEndDate(), formatter));
        reservationEntity.setStatus(ReservationStatus.valueOf(reservation.getStatus()));
        reservationRepository.save(reservationEntity);
    }

    @Override
    public Reservation update(Reservation reservation) {
        userClient.findById(reservation.getUserId());
        serviceClient.findById(reservation.getServiceId());
        Optional<Reservation> reservationInDB = reservationRepository.findById(reservation.getId());

        if (reservationInDB.isPresent()) {
            Reservation reservationUpdated = getReservation(reservation, reservationInDB);
            return reservationRepository.save(reservationUpdated);
        } else {
            throw new ReservationNotFoundException(reservation.getId());
        }
    }

    private static Reservation getReservation(Reservation reservation, Optional<Reservation> reservationInDB) {
        Reservation reservationUpdated = reservationInDB.get();
        reservationUpdated.setUserId(reservation.getUserId() != null ? reservation.getUserId() : reservationUpdated.getUserId());
        reservationUpdated.setServiceId(reservation.getServiceId() != null ? reservation.getServiceId() : reservationUpdated.getServiceId());
        reservationUpdated.setStartDate(reservation.getStartDate() != null ? reservation.getStartDate() : reservationUpdated.getStartDate());
        reservationUpdated.setEndDate(reservation.getEndDate() != null ? reservation.getEndDate() : reservationUpdated.getEndDate());
        reservationUpdated.setStatus(reservation.getStatus() != null ? reservation.getStatus() : reservationUpdated.getStatus());
        return reservationUpdated;
    }

    @Override
    public List<Reservation> findReservationByFilters(ReservationFiltersDTO filters) {
        return reservationRepositoryCustom.findReservationByFilters(filters);
    }
}
