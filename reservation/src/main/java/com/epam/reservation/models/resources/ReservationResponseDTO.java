package com.epam.reservation.models.resources;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReservationResponseDTO {
    @ApiModelProperty(notes = "Reservation Id", required = true)
    private Long reservationId;
    @ApiModelProperty(notes = "Reservation Details", required = true)
    private ReservationResourceDTO resourceDTO;
    @ApiModelProperty(notes = "Reservation status", required = false)
    private String status;
}
