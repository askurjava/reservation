package com.epam.reservation.models.error;

import lombok.Builder;
import lombok.Data;

/**
 * The type Error message.
 */
@Data
@Builder
public class ErrorMessage {
    private final Integer errorCode;
    private final String errorMessage;
}
