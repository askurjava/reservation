package com.epam.reservation.services;

import com.epam.reservation.dal.ReservationRepository;
import com.epam.reservation.exception.ReservationNotFoundException;
import com.epam.reservation.mapper.ReservationMapper;
import com.epam.reservation.models.entity.ReservationEntity;
import com.epam.reservation.models.resources.ReservationResourceDTO;
import com.epam.reservation.models.resources.ReservationResponseDTO;
import com.epam.reservation.models.resources.ReservationUpdateDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository repository;

    public ReservationServiceImpl(final ReservationRepository repository) {
        this.repository = repository;
    }

    @Override
    public ReservationResponseDTO addReservation(final ReservationResourceDTO resourceDTO) {
        return Optional.ofNullable(resourceDTO)
                .map(ReservationMapper::toReservationEntity)
                .map(repository::save)
                .map(ReservationMapper::toReservationResponseDTO)
                .orElse(null);
    }

    @Override
    public ReservationResponseDTO getReservationByReservationId(Long reservationId) {
        return Optional.ofNullable(reservationId)
                .flatMap(repository::findById)
                .map(ReservationMapper::toReservationResponseDTO)
                .orElseThrow(() -> new ReservationNotFoundException("Reservation not found for reservation Id: " + reservationId));
    }

    @Override
    public ReservationResponseDTO getReservationByGuestId(Long guestId) {
        return Optional.ofNullable(guestId)
                .map(repository::findByGuestId)
                .map(ReservationMapper::toReservationResponseDTO)
                .orElseThrow(() -> new ReservationNotFoundException("Reservation not found for Guest Id :" + guestId));
    }

    @Override
    public ReservationResponseDTO updateReservation(ReservationUpdateDTO updateDTO) {
        return Optional.ofNullable(updateDTO)
                .map(ReservationMapper::toReservationUpdateEntity)
                .map(repository::save)
                .map(ReservationMapper::toReservationResponseDTO)
                .orElse(null);
    }

    @Override
    public String cancelReservation(Long reservationId) {
        log.info("Request for Canceling the Reservation with Id: " + reservationId);
        if (reservationId != null) {
            Optional<ReservationEntity> guestEntity = repository.findById(reservationId);
            if (guestEntity.isEmpty()) {
                throw new ReservationNotFoundException("Reservation is not found to delete");
            } else {
                repository.save(guestEntity.get().builder().status("CANCELLED").build());
                return "Reservation is successfully cancelled";
            }
        }
        return null;
    }

}
