<html>
   <head>
      <title>Flight Reservation</title>
   </head>

   <body>
        <h2>Your Flight Reservation</h2>
            Airline: ${reservation.flight.operatingAirlines}<br>
            Flight Number: ${reservation.flight.flightNumber}<br>
            Departure City: ${reservation.flight.departureCity}<br>
            Arrival City: ${reservation.flight.arrivalCity}<br>
            Departure Date: ${reservation.flight.departureDate}<br>
            Estimated Departure Time: ${reservation.flight.estimatedDepartureTime}<br>

        <h2>Passenger Information</h2>
            First Name: ${reservation.passenger.firstName}<br>
            Last Name: ${reservation.passenger.lastName}<br>
            Email: ${reservation.passenger.email}<br>
            Phone Number: ${reservation.passenger.phone}<br>

        <form action="complete-checkin" method="post">
            Enter the Number Of Bags You Want To Check In: <input type="text" name="numberOfBags" placeholder=""><br/>
            <input type="hidden" name="reservationId" value="${reservation.id}">
            <input type="submit" value="Confirm Check In">
        </form>
   </body>
</html>