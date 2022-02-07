package com.adlere;

public enum ZonePriceEnum {
    ONE_TWO(240), ONE_TWO_THREE(280), THREE_FOUR(200), ONE_TWO_THREE_FOUR(300);

    private final Integer price;

    ZonePriceEnum(Integer price) {
        this.price = price;
    }

    public Integer getPrice() {
        return price;
    }
}
