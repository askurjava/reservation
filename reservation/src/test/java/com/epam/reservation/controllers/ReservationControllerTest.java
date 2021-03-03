package com.epam.reservation.controllers;

import com.epam.reservation.TestData;
import com.epam.reservation.models.resources.ReservationResourceDTO;
import com.epam.reservation.models.resources.ReservationResponseDTO;
import com.epam.reservation.models.resources.ReservationUpdateDTO;
import com.epam.reservation.services.ReservationService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import static org.mockito.ArgumentMatchers.any;

public class ReservationControllerTest {

    @InjectMocks
    private ReservationController controller;

    @Mock
    private ReservationService service;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddReservation() {
        Mockito.when(service.addReservation(any(ReservationResourceDTO.class))).thenReturn(TestData.reservationResponseDTO());
        ResponseEntity<ReservationResponseDTO> reservation = controller.createReservation(TestData.reservationResourceDTO());
        Assert.assertEquals(200, reservation.getStatusCodeValue());
        Mockito.verify(service).addReservation(any(ReservationResourceDTO.class));
    }

    @Test
    public void testGetReservationById() {
        Mockito.when(service.getReservationByReservationId(1L)).thenReturn(TestData.reservationResponseDTO());
        ResponseEntity<ReservationResponseDTO> reservationById = controller.getReservationById(1L);
        Assert.assertEquals(200, reservationById.getStatusCodeValue());
        Mockito.verify(service).getReservationByReservationId(1L);
    }

    @Test
    public void testGetReservationByGuestId() {
        Mockito.when(service.getReservationByGuestId(1L)).thenReturn(TestData.reservationResponseDTO());
        ResponseEntity<ReservationResponseDTO> reservationByGuestId = controller.getReservationByGuestId(1L);
        Assert.assertEquals(200, reservationByGuestId.getStatusCodeValue());
        Mockito.verify(service).getReservationByGuestId(1L);
    }

    @Test
    public void testCancelReservation() {
        Mockito.when(service.cancelReservation(1L)).thenReturn("Reservation is successfully cancelled");
        ResponseEntity<String> responseEntity = controller.deleteReservation(1L);
        Assert.assertEquals("Reservation is successfully cancelled", responseEntity.getBody());
        Mockito.verify(service).cancelReservation(1L);
    }

    @Test
    public void testUpdateReservation() {
        Mockito.when(service.updateReservation(any(ReservationUpdateDTO.class))).thenReturn(TestData.reservationResponseDTO());
        ResponseEntity<ReservationResponseDTO> responseEntity = controller.updateReservation(TestData.reservationUpdateDTO());
        Assert.assertEquals(200, responseEntity.getStatusCodeValue());
        Mockito.verify(service).updateReservation(any(ReservationUpdateDTO.class));
    }
}
