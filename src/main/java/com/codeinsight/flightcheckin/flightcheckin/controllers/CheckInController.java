package com.codeinsight.flightcheckin.flightcheckin.controllers;

import com.codeinsight.flightcheckin.flightcheckin.integration.ReservationRestClient;
import com.codeinsight.flightcheckin.flightcheckin.integration.dto.Reservation;
import com.codeinsight.flightcheckin.flightcheckin.integration.dto.ReservationUpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CheckInController {

    @Autowired
    ReservationRestClient restClient;

    @RequestMapping("show-checkin")
    public String showCheckIn() {
        return "checkIn";
    }

    @RequestMapping("start-checkin")
    public String startCheckIn(@RequestParam("reservationId") Long reservationId, ModelMap modelMap) {
        Reservation reservation = restClient.findReservation(reservationId);
        modelMap.put("reservation", reservation);
        return "displayReservation";
    }

    @RequestMapping("complete-checkin")
    public String completeCheckIn(@RequestParam("reservationId") Long reservationId,
                                 @RequestParam("numberOfBags") int numberOfBags){
        ReservationUpdateRequest request = new ReservationUpdateRequest();
        request.setId(reservationId);
        request.setCheckedIn(true);
        request.setNumberOfBags(numberOfBags);
        restClient.updateReservation(request);
        return "checkInConformation";
    }
}


