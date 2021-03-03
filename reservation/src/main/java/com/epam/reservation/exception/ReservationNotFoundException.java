package com.epam.reservation.exception;


/**
 * The type Reservation not found exception.
 */
public class ReservationNotFoundException extends RuntimeException {

    /**
     * Instantiates a new Reservation not found exception.
     *
     * @param message the message
     */
    public ReservationNotFoundException(String message) {
        super(message);
    }
}
