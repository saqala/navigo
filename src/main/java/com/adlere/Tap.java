package com.adlere;

public class Tap {

    private final Integer unixTimestamp;
    private final Integer customerId;
    private final String station;

    public Tap(Integer unixTimestamp, Integer customerId, String station) {
        this.unixTimestamp = unixTimestamp;
        this.customerId = customerId;
        this.station = station;
    }

    public Integer getUnixTimestamp() {
        return unixTimestamp;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public String getStation() {
        return station;
    }
}
