package com.epam.reservation;

import com.epam.reservation.models.entity.ReservationEntity;
import com.epam.reservation.models.resources.ReservationResourceDTO;
import com.epam.reservation.models.resources.ReservationResponseDTO;
import com.epam.reservation.models.resources.ReservationUpdateDTO;

public class TestData {

    public static ReservationEntity reservationEntity(){
        return ReservationEntity.builder()
                .status("COMPLETED")
                .endDate("2021-04-10")
                .startDate("2021-04-05")
                .guestId(1L)
                .hotelId(1L)
                .reservationId(1L)
                .build();
    }

    public static ReservationResourceDTO reservationResourceDTO(){
        return ReservationResourceDTO.builder()
                .endDate("2021-04-10")
                .startDate("2021-04-05")
                .guestId(1L)
                .hotelId(1L)
                .build();
    }

    public static ReservationResponseDTO reservationResponseDTO(){
        return ReservationResponseDTO.builder()
                .reservationId(1L)
                .resourceDTO(reservationResourceDTO())
                .status("COMPLETED")
                .build();
    }

    public static ReservationUpdateDTO reservationUpdateDTO(){
        return ReservationUpdateDTO.builder()
                .reservationId(1L)
                .guestId(1L)
                .hotelId(1L)
                .startDate("2021-04-01")
                .endDate("2021-04-10")
                .status("UPDATED")
                .build();
    }
}
