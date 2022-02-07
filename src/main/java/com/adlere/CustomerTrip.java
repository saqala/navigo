package com.adlere;

import java.util.List;

public class CustomerTrip {

    private final Integer customerId;
    private final List<Trip> trips;

    public CustomerTrip(Integer customerId, List<Trip> trips) {
        this.customerId = customerId;
        this.trips = trips;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public Integer getTotalCostInCents() {
        return trips.stream().map(Trip::getCostInCents).reduce(0, Integer::sum);
    }

    public List<Trip> getTrips() {
        return trips;
    }
}
