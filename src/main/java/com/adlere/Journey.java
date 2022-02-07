package com.adlere;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.groupingBy;

public class Journey {

    private final List<Tap> taps;

    public Journey(List<Tap> taps) {
        this.taps = taps;
    }

    public List<CustomerTrip> calculateCustomerTrips() {
        return taps.stream().collect(groupingBy(Tap::getCustomerId)).entrySet().stream().map(customerMap -> {
            Integer id = customerMap.getKey();
            List<Tap> customerTaps = customerMap.getValue();
            return createCustomer(id, customerTaps);
        }).collect(Collectors.toList());

    }

    private CustomerTrip createCustomer(Integer id, List<Tap> customerTaps) {
        customerTaps.sort(Comparator.comparing(Tap::getUnixTimestamp));
        List<Trip> trips = IntStream.iterate(0, i -> i + 2).limit(customerTaps.size()/2).mapToObj(i -> {
            Tap startTap = customerTaps.get(i);
            Tap endTap = customerTaps.get(i+1);
            return createTrip(startTap, endTap);
        }).collect(Collectors.toList());
        return new CustomerTrip(id, trips);
    }

    private Trip createTrip(Tap startTap, Tap endTap) {
        TripMonitor calculator = new TripMonitor(startTap, endTap);
        return new Trip(calculator.getStationStart(), calculator.getStationEnd(), calculator.getStartedJourneyAt(),
                calculator.getCostInCents(), calculator.getZoneFrom(), calculator.getZoneTo());
    }

}
