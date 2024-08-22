package com.linktic.microservice_reservations.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReservationFiltersDTO {
    private Long userId;
    private Long serviceId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String status;
}
