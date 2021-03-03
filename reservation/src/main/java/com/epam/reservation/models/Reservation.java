package com.epam.reservation.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class Reservation {

    private String reservationId;
    private String guest;
    private String inTime;
    private String outTime;
    private String hotelName;
}
