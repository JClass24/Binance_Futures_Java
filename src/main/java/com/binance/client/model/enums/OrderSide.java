package com.binance.client.model.enums;

/**
 * buy, sell, both.
 */

public enum OrderSide {
    BUY(1),
    SELL(-1);

    private final int code;

    OrderSide(int side) {
        this.code = side;
    }

    public int getCode() {
        return code;
    }
}