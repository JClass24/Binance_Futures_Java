package com.binance.client.model.event;

import com.binance.client.model.market.CandleConfig;
import com.binance.client.model.market.Candlestick;

import java.math.BigDecimal;

public class CandlestickEvent {
    private CandleConfig candleConfig;

    private Candlestick candlestick;

    private String eventType;

    private Long eventTime;

    private Long firstTradeId;

    private Long lastTradeId;

    private Boolean isClosed;

    private Long ignore;

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public Long getEventTime() {
        return eventTime;
    }

    public void setEventTime(Long eventTime) {
        this.eventTime = eventTime;
    }

    public Long getFirstTradeId() {
        return firstTradeId;
    }

    public void setFirstTradeId(Long firstTradeId) {
        this.firstTradeId = firstTradeId;
    }

    public Long getLastTradeId() {
        return lastTradeId;
    }

    public void setLastTradeId(Long lastTradeId) {
        this.lastTradeId = lastTradeId;
    }

    public Boolean getIsClosed() {
        return isClosed;
    }

    public void setIsClosed(Boolean isClosed) {
        this.isClosed = isClosed;
    }

    public Long getIgnore() {
        return ignore;
    }

    public void setIgnore(Long ignore) {
        this.ignore = ignore;
    }

    public CandleConfig getCandleConfig() {
        return candleConfig;
    }

    public void setCandleConfig(CandleConfig candleConfig) {
        this.candleConfig = candleConfig;
    }

    public Candlestick getCandlestick() {
        return candlestick;
    }

    public void setCandlestick(Candlestick candlestick) {
        this.candlestick = candlestick;
    }

    @Override
    public String toString() {
        return "CandlestickEvent{" +
                "candleConfig=" + candleConfig +
                ", candlestick=" + candlestick +
                ", eventType='" + eventType + '\'' +
                ", eventTime=" + eventTime +
                ", firstTradeId=" + firstTradeId +
                ", lastTradeId=" + lastTradeId +
                ", isClosed=" + isClosed +
                ", ignore=" + ignore +
                '}';
    }
}
