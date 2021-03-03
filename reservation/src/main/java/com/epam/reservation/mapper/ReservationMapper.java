package com.epam.reservation.mapper;

import com.epam.reservation.models.entity.ReservationEntity;
import com.epam.reservation.models.resources.ReservationResourceDTO;
import com.epam.reservation.models.resources.ReservationResponseDTO;
import com.epam.reservation.models.resources.ReservationUpdateDTO;

/**
 * The type Reservation mapper.
 */
public class ReservationMapper {

    /**
     * To reservation entity reservation entity.
     *
     * @param resourceDTO the resource dto
     * @return the reservation entity
     */
    public static ReservationEntity toReservationEntity(final ReservationResourceDTO resourceDTO){
        return ReservationEntity.builder()
                .hotelId(resourceDTO.getHotelId())
                .guestId(resourceDTO.getGuestId())
                .startDate(resourceDTO.getStartDate())
                .endDate(resourceDTO.getEndDate())
                .build();
    }

    /**
     * To reservation dto reservation resource dto.
     *
     * @param reservationEntity the reservation entity
     * @return the reservation resource dto
     */
    public static ReservationResourceDTO toReservationDTO(final ReservationEntity reservationEntity){
        return ReservationResourceDTO.builder()
                .hotelId(reservationEntity.getHotelId())
                .guestId(reservationEntity.getGuestId())
                .startDate(reservationEntity.getStartDate())
                .endDate(reservationEntity.getEndDate())
                .build();
    }

    /**
     * To reservation response dto reservation response dto.
     *
     * @param reservationEntity the reservation entity
     * @return the reservation response dto
     */
    public static ReservationResponseDTO toReservationResponseDTO(final ReservationEntity reservationEntity){
        return ReservationResponseDTO.builder()
                .reservationId(reservationEntity.getReservationId())
                .resourceDTO(toReservationDTO(reservationEntity))
                .status(reservationEntity.getStatus())
                .build();
    }

    /**
     * To reservation update entity reservation entity.
     *
     * @param resourceDTO the resource dto
     * @return the reservation entity
     */
    public static ReservationEntity toReservationUpdateEntity(final ReservationUpdateDTO resourceDTO){
        return ReservationEntity.builder()
                .hotelId(resourceDTO.getHotelId())
                .guestId(resourceDTO.getGuestId())
                .startDate(resourceDTO.getStartDate())
                .endDate(resourceDTO.getEndDate())
                .status(resourceDTO.getStatus())
                .build();
    }


}
