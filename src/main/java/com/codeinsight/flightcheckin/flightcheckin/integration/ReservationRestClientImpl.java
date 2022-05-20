package com.codeinsight.flightcheckin.flightcheckin.integration;

import com.codeinsight.flightcheckin.flightcheckin.integration.dto.Reservation;
import com.codeinsight.flightcheckin.flightcheckin.integration.dto.ReservationUpdateRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ReservationRestClientImpl implements ReservationRestClient {

    public static final String RESERVATION_REST_URL = "http://localhost:8080/flightreservation/reservations/";

    //Sends a request(part of request is id in this case which we got from controller) to server's RestController and expects return of Reservation object
    @Override
    public Reservation findReservation(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(RESERVATION_REST_URL+id, Reservation.class);
    }

    //Sends a request(part of request is ReservationUpdateRequest in this case which we got from controller) to server's RestController and expects return of Reservation object
    @Override
    public Reservation updateReservation(ReservationUpdateRequest request) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForObject(RESERVATION_REST_URL, request, Reservation.class);
    }
}
