package com.adlere;

import java.util.List;

public class JourneySummary {

    private final List<CustomerTrip> customerTrips;

    public JourneySummary(List<CustomerTrip> customerTrips) {
        this.customerTrips = customerTrips;
    }

    public List<CustomerTrip> getCustomerSummaries() {
        return customerTrips;
    }
}
