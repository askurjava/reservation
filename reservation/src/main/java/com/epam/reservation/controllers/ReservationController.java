package com.epam.reservation.controllers;


import com.epam.reservation.api.ReservationApi;
import com.epam.reservation.models.resources.ReservationResourceDTO;
import com.epam.reservation.models.resources.ReservationResponseDTO;
import com.epam.reservation.models.resources.ReservationUpdateDTO;
import com.epam.reservation.services.ReservationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReservationController implements ReservationApi {

    private final ReservationService service;

    public ReservationController(final ReservationService service) {
        this.service = service;
    }


    @Override
    public ResponseEntity<ReservationResponseDTO> getReservationById(final Long reservationId) {
        return ResponseEntity.ok().body(service.getReservationByReservationId(reservationId));
    }

    @Override
    public ResponseEntity<ReservationResponseDTO> getReservationByGuestId(final Long guestId) {
        return ResponseEntity.ok().body(service.getReservationByGuestId(guestId));
    }

    @Override
    public ResponseEntity<ReservationResponseDTO> createReservation(ReservationResourceDTO resourceDTO) {
        return ResponseEntity.ok().body(service.addReservation(resourceDTO));
    }

    @Override
    public ResponseEntity<ReservationResponseDTO> updateReservation(ReservationUpdateDTO updateDTO) {
        return ResponseEntity.ok().body(service.updateReservation(updateDTO));
    }

    @Override
    public ResponseEntity<String> deleteReservation(final Long reservationId) {
        return ResponseEntity.ok().body(service.cancelReservation(reservationId));
    }


}
