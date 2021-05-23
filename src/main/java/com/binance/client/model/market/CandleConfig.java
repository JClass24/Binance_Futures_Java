package com.binance.client.model.market;

import com.binance.client.model.enums.SymbolType;

import java.util.Objects;

public class CandleConfig {
    private String symbol;
    private SymbolType symbolType;
    private String interval;

    public CandleConfig(String symbol, SymbolType symbolType, String interval) {
        this.symbol = symbol;
        this.symbolType = symbolType;
        this.interval = interval;
    }

    public CandleConfig() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CandleConfig that = (CandleConfig) o;
        return Objects.equals(symbol, that.symbol) && symbolType == that.symbolType && Objects.equals(interval, that.interval);
    }

    @Override
    public int hashCode() {
        return Objects.hash(symbol, symbolType, interval);
    }

    @Override
    public String toString() {
        return "CandleConfig{" +
                "symbol='" + symbol + '\'' +
                ", symbolType=" + symbolType +
                ", interval='" + interval + '\'' +
                '}';
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
