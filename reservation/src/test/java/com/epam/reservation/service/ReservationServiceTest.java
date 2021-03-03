package com.epam.reservation.service;

import com.epam.reservation.TestData;
import com.epam.reservation.dal.ReservationRepository;
import com.epam.reservation.exception.ReservationNotFoundException;
import com.epam.reservation.models.entity.ReservationEntity;
import com.epam.reservation.models.resources.ReservationResponseDTO;
import com.epam.reservation.services.ReservationServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;

public class ReservationServiceTest {

    @InjectMocks
    private ReservationServiceImpl service;

    @Mock
    private ReservationRepository repository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    private static final ReservationEntity RESERVATION_ENTITY = TestData.reservationEntity();

    @Test
    public void testCreateReservation() {
        Mockito.when(repository.save(any(ReservationEntity.class))).thenReturn(RESERVATION_ENTITY);
        ReservationResponseDTO responseDTO = service.addReservation(TestData.reservationResourceDTO());
        Assert.assertNotNull(responseDTO);
        Mockito.verify(repository).save(any(ReservationEntity.class));
    }

    @Test
    public void testGetReservationById() {
        Mockito.when(repository.findById(1L)).thenReturn(Optional.ofNullable(RESERVATION_ENTITY));
        ReservationResponseDTO responseDTO = service.getReservationByReservationId(1L);
        Assert.assertNotNull(responseDTO);
        Mockito.verify(repository).findById(1L);
    }

    @Test(expected = ReservationNotFoundException.class)
    public void testGetReservationByNullId() {
        service.getReservationByReservationId(1L);
    }

    @Test
    public void testGetReservationByGuestId() {
        Mockito.when(repository.findByGuestId(1L)).thenReturn(RESERVATION_ENTITY);
        ReservationResponseDTO responseDTO = service.getReservationByGuestId(1L);
        Assert.assertNotNull(responseDTO);
        Mockito.verify(repository).findByGuestId(1L);
    }

    @Test(expected = ReservationNotFoundException.class)
    public void testGetReservationByNullGuestId() {
        service.getReservationByGuestId(1L);
    }

    @Test
    public void testCanceledReservation() {
        Mockito.when(repository.findById(1L)).thenReturn(Optional.ofNullable(RESERVATION_ENTITY));
        String s = service.cancelReservation(1L);
        Assert.assertNotNull(s);
        Mockito.verify(repository).findById(1L);
    }

    @Test
    public void testCanceledReservationWhenReservationIdIsNull() {
        String s = service.cancelReservation(null);
        Assert.assertNull(s);
    }

    @Test(expected = ReservationNotFoundException.class)
    public void testCanceledReservationWhenReservationIdNotFound(){
        Mockito.when(repository.findById(1L)).thenReturn(Optional.empty());
        service.cancelReservation(1L);
        Mockito.verify(repository).findById(1L);
    }

}
