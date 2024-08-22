package com.linktic.microservice_reservations.repository;

import com.linktic.microservice_reservations.dto.ReservationFiltersDTO;
import com.linktic.microservice_reservations.entities.Reservation;
import com.linktic.microservice_reservations.entities.ReservationStatus;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ReservationRepositoryCustomImpl implements IReservationRepositoryCustom {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Reservation> findReservationByFilters(ReservationFiltersDTO filters) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Reservation> cq = criteriaBuilder.createQuery(Reservation.class);
        Root<Reservation> reservation = cq.from(Reservation.class);
        List<Predicate> predicates = new ArrayList<>();
        if (filters.getUserId() != null) {
            predicates.add(criteriaBuilder.equal(reservation.get("userId"), filters.getUserId()));
        }
        if (filters.getServiceId() != null) {
            predicates.add(criteriaBuilder.equal(reservation.get("serviceId"), filters.getServiceId()));
        }
        if (filters.getStartDate() != null) {
            predicates.add(criteriaBuilder.greaterThanOrEqualTo(reservation.get("startDate"), filters.getStartDate()));
        }
        if (filters.getEndDate() != null) {
            predicates.add(criteriaBuilder.lessThanOrEqualTo(reservation.get("endDate"), filters.getEndDate()));
        }
        if (filters.getStatus() != null) {
            predicates.add(criteriaBuilder.equal(reservation.get("status"), ReservationStatus.valueOf(filters.getStatus())));
        }
        cq.where(predicates.toArray(new Predicate[0]));
        return entityManager.createQuery(cq).getResultList();
    }
}
