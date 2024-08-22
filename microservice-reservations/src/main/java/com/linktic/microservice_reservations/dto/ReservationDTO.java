package com.linktic.microservice_reservations.dto;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReservationDTO {

        @NotNull(message = "User ID cannot be null")
        private Long userId;

        @NotNull(message = "Service ID cannot be null")
        private Long serviceId;

        @NotNull(message = "Status cannot be null")
        private String status;

        @NotNull(message = "Start Date cannot be null")
        private String startDate;

        @NotNull(message = "End Date cannot be null")
        private String endDate;
}
