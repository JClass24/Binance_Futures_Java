package com.binance.client.model.market;

import com.binance.client.model.enums.CandlestickInterval;

/**
 * @author jclass
 */
public class CandlesCombine {
    private String symbol;
    private CandlestickInterval interval;

    public CandlesCombine(String symbol, CandlestickInterval interval) {
        this.symbol = symbol;
        this.interval = interval;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public CandlestickInterval getInterval() {
        return interval;
    }

    public void setInterval(CandlestickInterval interval) {
        this.interval = interval;
    }
}
