package com.adlere;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

import static com.adlere.ZonePriceEnum.*;

public class TripMonitor {

    private final Tap startTap;
    private final Tap endTap;

    public TripMonitor(Tap startTap, Tap endTap) {
        this.startTap = startTap;
        this.endTap = endTap;
    }

    public String getStationStart() {
        return startTap.getStation();
    }

    public String getStationEnd() {
        return endTap.getStation();
    }

    public Integer getStartedJourneyAt() {
        return startTap.getUnixTimestamp();
    }

    public Integer getCostInCents() {
        return calculateCost(getZoneFrom(), getZoneTo());
    }

    public Integer getZoneFrom() {
        return findZone(getStationStart(), getStationEnd());
    }

    public Integer getZoneTo() {
        return findZone(getStationEnd(), getStationStart());
    }

    private Integer findZone(String stationStart, String stationEnd) {
        List<Integer> startZones = StationEnum.valueOf(stationStart).getZones();
        List<Integer> endZones = StationEnum.valueOf(stationEnd).getZones();
        BinaryOperator<Integer> minDistance = (distance1, distance2) -> distance1 < distance2 ? distance1 : distance2;
        Map<Integer, Integer> distance = startZones.stream().flatMap(start -> endZones.stream().collect(Collectors.toMap(end -> start, end -> Math.abs(start - end), minDistance)).entrySet().stream()).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        return Collections.min(distance.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    private Integer calculateCost(Integer zoneStart, Integer zoneEnd) {

        if ((zoneStart == 1 || zoneStart == 2) && (zoneEnd == 1 || zoneEnd == 2)) return ONE_TWO.getPrice();
        if ((zoneStart == 3 && zoneEnd == 2) || (zoneStart == 3 && zoneEnd == 1) || ((zoneStart == 1 || zoneStart == 2) && zoneEnd == 3)) return ONE_TWO_THREE.getPrice();
        if ((zoneStart == 3 || zoneStart == 4) && (zoneEnd == 3 || zoneEnd == 4)) return THREE_FOUR.getPrice();
        if ((zoneStart == 4 && zoneEnd == 2) || (zoneStart == 4 && zoneEnd == 1) || ((zoneStart == 1 || zoneStart == 2) && zoneEnd == 4)) return ONE_TWO_THREE_FOUR.getPrice();
        return 0;
    }

}
