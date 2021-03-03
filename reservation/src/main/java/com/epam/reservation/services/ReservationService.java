package com.epam.reservation.services;

import com.epam.reservation.models.resources.ReservationResourceDTO;
import com.epam.reservation.models.resources.ReservationResponseDTO;
import com.epam.reservation.models.resources.ReservationUpdateDTO;

/**
 * The interface Reservation service.
 */
public interface ReservationService {

    /**
     * Add reservation reservation response dto.
     *
     * @param resourceDTO the resource dto
     * @return the reservation response dto
     */
    ReservationResponseDTO addReservation(ReservationResourceDTO resourceDTO);

    /**
     * Gets reservation by reservation id.
     *
     * @param reservationId the reservation id
     * @return the reservation by reservation id
     */
    ReservationResponseDTO getReservationByReservationId(Long reservationId);

    /**
     * Gets reservation by guest id.
     *
     * @param guestId the guest id
     * @return the reservation by guest id
     */
    ReservationResponseDTO getReservationByGuestId(Long guestId);

    /**
     * Update reservation reservation response dto.
     *
     * @param updateDTO the update dto
     * @return the reservation response dto
     */
    ReservationResponseDTO updateReservation(ReservationUpdateDTO updateDTO);

    /**
     * Cancel reservation string.
     *
     * @param reservationId the reservation id
     * @return the string
     */
    String cancelReservation(Long reservationId);
}
