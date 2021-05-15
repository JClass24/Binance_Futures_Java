package com.binance.client.model.market;

public class BookDepth {
    private String symbol;
    private Integer limit;

    public BookDepth(String symbol, Integer limit) {
        this.symbol = symbol;
        this.limit = limit;
    }

    public BookDepth() {
    }

    @Override
    public String toString() {
        return "BookDepth{" +
                "symbol='" + symbol + '\'' +
                ", limit=" + limit +
                '}';
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }
}
