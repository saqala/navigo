package com.adlere;

import java.util.List;

public enum StationEnum {
    A(1), B(1), C(2, 3), D(2), E(2, 3), F(3, 4), G(4), H(4), I(4);

    private final List<Integer> zones;

    StationEnum(Integer... zones) {
        this.zones = List.of(zones);
    }

    public List<Integer> getZones() {
        return zones;
    }
}
