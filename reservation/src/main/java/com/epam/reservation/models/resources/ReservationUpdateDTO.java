package com.epam.reservation.models.resources;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReservationUpdateDTO {

    @ApiModelProperty(notes = "Reservation id", required = true)
    private Long reservationId;
    @ApiModelProperty(notes = "Hotel id", required = true)
    private Long hotelId;
    @ApiModelProperty(notes = "Guest id", required = true)
    private Long guestId;
    @ApiModelProperty(notes = "Reservation start date", required = true)
    private String startDate;
    @ApiModelProperty(notes = "Reservation end date", required = true)
    private String endDate;
    @ApiModelProperty(notes = "Reservation status", required = false)
    private String status;

}
