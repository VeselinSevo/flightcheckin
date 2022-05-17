package com.codeinsight.flightcheckin.flightcheckin.integration;

import com.codeinsight.flightcheckin.flightcheckin.integration.dto.Reservation;
import com.codeinsight.flightcheckin.flightcheckin.integration.dto.ReservationUpdateRequest;

public interface ReservationRestClient {
    public Reservation findReservation(Long id);

    public Reservation updateReservation(ReservationUpdateRequest request);

}
