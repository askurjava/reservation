package com.epam.reservation.api;

import com.epam.reservation.models.error.ErrorMessage;
import com.epam.reservation.models.resources.ReservationResourceDTO;
import com.epam.reservation.models.resources.ReservationResponseDTO;
import com.epam.reservation.models.resources.ReservationUpdateDTO;
import io.swagger.annotations.*;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * The interface Reservation api.
 */
@Api(value = "reservation")
@RequestMapping("reservation")
public interface ReservationApi {


    /**
     * Gets reservation by id.
     *
     * @param reservationId the reservation id
     * @return the reservation by id
     */
    @ApiOperation(
            value = "Request to fetch reservation by Reservation ID",
            response = ReservationResponseDTO.class,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            httpMethod = "GET"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Hotel reservation has been completed successfully.", response = ReservationResponseDTO.class),
            @ApiResponse(code = 400, message = "Business validation fail", response = ErrorMessage.class),
            @ApiResponse(code = 401, message = "Authentication failed."),
            @ApiResponse(code = 403, message = "You are not authorized to do this operation."),
            @ApiResponse(code = 404, message = "Resource not found.")
    })
    @GetMapping(value = "/getReservation/{reservationId}")
    ResponseEntity<ReservationResponseDTO> getReservationById(@ApiParam(value = "Reservation Id for searching reservation details")
                                                              @PathVariable final Long reservationId);

    /**
     * Gets reservation by guest id.
     *
     * @param guestId the guest id
     * @return the reservation by guest id
     */
    @ApiOperation(
            value = "Request to fetch reservation by Guest",
            response = ReservationResponseDTO.class,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            httpMethod = "GET"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Hotel reservation has been completed successfully.", response = ReservationResponseDTO.class),
            @ApiResponse(code = 400, message = "Business validation fail", response = ErrorMessage.class),
            @ApiResponse(code = 401, message = "Authentication failed."),
            @ApiResponse(code = 403, message = "You are not authorized to do this operation."),
            @ApiResponse(code = 404, message = "Resource not found.")
    })
    @GetMapping(value = "/getReservationByGuest/{guestId}")
    ResponseEntity<ReservationResponseDTO> getReservationByGuestId(@ApiParam(value = "Guest Id for searching reservation details")
                                                                   @PathVariable final Long guestId);


    /**
     * Create reservation response entity.
     *
     * @param resourceDTO the resource dto
     * @return the response entity
     */
    @ApiOperation(
            value = "Request for add new hotel reservation",
            response = ReservationResponseDTO.class,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            httpMethod = "POST"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Hotel reservation has been completed successfully.", response = ReservationResponseDTO.class),
            @ApiResponse(code = 400, message = "Business validation fail", response = ErrorMessage.class),
            @ApiResponse(code = 401, message = "Authentication failed."),
            @ApiResponse(code = 403, message = "You are not authorized to do this operation."),
            @ApiResponse(code = 404, message = "Resource not found.")
    })
    @PostMapping(value = "/addReservation", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<ReservationResponseDTO> createReservation(@ApiParam(value = "Request for add hotel reservation")
                                                             @RequestBody final ReservationResourceDTO resourceDTO);

    /**
     * Update reservation response entity.
     *
     * @param updateDTO the update dto
     * @return the response entity
     */
    @ApiOperation(
            value = "Request to Update a hotel reservation",
            response = ReservationResponseDTO.class,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            httpMethod = "PUT"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Hotel reservation deleted successfully.", response = ReservationResponseDTO.class),
            @ApiResponse(code = 400, message = "Business validation fail", response = ErrorMessage.class),
            @ApiResponse(code = 401, message = "Authentication failed."),
            @ApiResponse(code = 403, message = "You are not authorized to do this operation."),
            @ApiResponse(code = 404, message = "Resource not found.")
    })
    @PutMapping(value = "/updateReservation")
    ResponseEntity<ReservationResponseDTO> updateReservation(@ApiParam(name = "Request to update a hotel reservation")
                                                             @RequestBody final ReservationUpdateDTO updateDTO);

    /**
     * Delete reservation response entity.
     *
     * @param reservationId the reservation id
     * @return the response entity
     */
    @ApiOperation(
            value = "Request for delete a hotel reservation",
            response = String.class,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            httpMethod = "DELETE"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Hotel reservation deleted successfully.", response = String.class),
            @ApiResponse(code = 400, message = "Business validation fail", response = ErrorMessage.class),
            @ApiResponse(code = 401, message = "Authentication failed."),
            @ApiResponse(code = 403, message = "You are not authorized to do this operation."),
            @ApiResponse(code = 404, message = "Resource not found.")
    })
    @DeleteMapping(value = "/delete/{reservationId}")
    ResponseEntity<String> deleteReservation(@ApiParam(value = "Reservation Id for deleting the reservation details")
                                             @PathVariable final Long reservationId);
}
