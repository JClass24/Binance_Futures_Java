package com.binance.client.model.market;

import com.binance.client.model.enums.SymbolType;

import java.util.Objects;

public class Candle {
    private String symbol;
    private SymbolType symbolType;
    private String interval;

    public Candle(String symbol, SymbolType symbolType, String interval) {
        this.symbol = symbol;
        this.symbolType = symbolType;
        this.interval = interval;
    }

    public Candle() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Candle candle = (Candle) o;
        return Objects.equals(symbol, candle.symbol) && symbolType == candle.symbolType && Objects.equals(interval, candle.interval);
    }

    @Override
    public int hashCode() {
        return Objects.hash(symbol, symbolType, interval);
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getInterval() {
        return interval;
    }

    public void setInterval(String interval) {
        this.interval = interval;
    }

    public SymbolType getSymbolType() {
        return symbolType;
    }

    public void setSymbolType(SymbolType symbolType) {
        this.symbolType = symbolType;
    }
}
