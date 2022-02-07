package com.adlere;

import org.junit.jupiter.api.Test;

import static com.adlere.ZonePriceEnum.ONE_TWO;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TripMonitorTest {

    Integer customerId = 1;
    Integer startTime = 10;
    String startStation = "A";
    Integer endTime = 20;
    String endStation = "C";
    Tap startTap = new Tap(10, customerId, startStation);
    Tap endTap = new Tap(endTime, customerId, endStation);

    @Test
    void verify_customer_trip_properties() {
        TripMonitor monitor = new TripMonitor(startTap, endTap);
        assertEquals(monitor.getStationStart(), startStation);
        assertEquals(monitor.getStationEnd(), endStation);
        assertEquals(monitor.getStartedJourneyAt(), startTime);
        assertEquals(monitor.getCostInCents(), ONE_TWO.getPrice());
        assertEquals(monitor.getZoneFrom(), 1);
        assertEquals(monitor.getZoneTo(), 2);
    }


}
