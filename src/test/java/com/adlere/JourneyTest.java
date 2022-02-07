package com.adlere;

import org.junit.jupiter.api.Test;

import java.util.List;

import static com.adlere.ZonePriceEnum.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class JourneyTest {

    @Test
    void check_journey_summary_properties(){

        Tap tap1 = new Tap(1,1,"A");
        Tap tap2 = new Tap(2,1,"D");
        Tap tap3 = new Tap(2,2,"B");
        Tap tap4 = new Tap(3,2,"C");
        Tap tap5 = new Tap(10,2,"G");
        Tap tap6 = new Tap(20,2,"D");

        Journey journey = new Journey(List.of(tap1, tap2, tap3, tap4, tap5, tap6));

        List<CustomerTrip> customerTrips = journey.calculateCustomerTrips();

        assertNotNull(customerTrips);
        assertEquals(2, customerTrips.size());

        CustomerTrip customer1 = customerTrips.get(0);
        assertEquals(1, customer1.getCustomerId());
        assertEquals(240, customer1.getTotalCostInCents());
        assertNotNull(customer1.getTrips());
        assertEquals(1, customer1.getTrips().size());

        Trip customer1Trip = customer1.getTrips().get(0);
        assertEquals("A", customer1Trip.getStationStart());
        assertEquals("D", customer1Trip.getStationEnd());
        assertEquals(1, customer1Trip.getStartedJourneyAt());
        assertEquals(ONE_TWO.getPrice(), customer1Trip.getCostInCents());
        assertEquals(1, customer1Trip.getZoneFrom());
        assertEquals(2, customer1Trip.getZoneTo());


        CustomerTrip customer2 = customerTrips.get(1);
        assertEquals(2, customer2.getCustomerId());
        assertEquals(540, customer2.getTotalCostInCents());
        assertNotNull(customer2.getTrips());
        assertEquals(2, customer2.getTrips().size());

        Trip customer2Trip = customer2.getTrips().get(0);
        assertEquals(ONE_TWO.getPrice(), customer1Trip.getCostInCents());
        assertEquals(1, customer2Trip.getZoneFrom());
        assertEquals(2, customer2Trip.getZoneTo());

        Trip customer2Trip2 = customer2.getTrips().get(1);
        assertEquals(ONE_TWO_THREE_FOUR.getPrice(), customer2Trip2.getCostInCents());
        assertEquals(4, customer2Trip2.getZoneFrom());
        assertEquals(2, customer2Trip2.getZoneTo());

    }

}
