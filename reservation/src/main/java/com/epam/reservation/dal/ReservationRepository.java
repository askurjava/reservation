package com.epam.reservation.dal;

import com.epam.reservation.models.entity.ReservationEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Reservation repository.
 */
@Repository
public interface ReservationRepository extends CrudRepository<ReservationEntity, Long> {

    /**
     * Find by guest id reservation entity.
     *
     * @param guestId the guest id
     * @return the reservation entity
     */
    ReservationEntity findByGuestId(Long guestId);
}
