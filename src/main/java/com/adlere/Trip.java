package com.adlere;

public class Trip {

    private final String stationStart;
    private final String stationEnd;
    private final Integer startedJourneyAt;
    private final Integer costInCents;
    private final Integer zoneFrom;
    private final Integer zoneTo;

    public Trip(String stationStart, String stationEnd, Integer startedJourneyAt, Integer costInCents, Integer zoneFrom, Integer zoneTo) {
        this.stationStart = stationStart;
        this.stationEnd = stationEnd;
        this.startedJourneyAt = startedJourneyAt;
        this.costInCents = costInCents;
        this.zoneFrom = zoneFrom;
        this.zoneTo = zoneTo;
    }

    public String getStationStart() {
        return stationStart;
    }

    public String getStationEnd() {
        return stationEnd;
    }

    public Integer getStartedJourneyAt() {
        return startedJourneyAt;
    }

    public Integer getCostInCents() {
        return costInCents;
    }

    public Integer getZoneFrom() {
        return zoneFrom;
    }

    public Integer getZoneTo() {
        return zoneTo;
    }
}
