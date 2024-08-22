package com.linktic.microservice_reservations.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReservationFiltersDTO {
    private Long userId;
    private Long serviceId;
    private LocalDate startDate;
    private LocalDate endDate;
    private String status;
}
