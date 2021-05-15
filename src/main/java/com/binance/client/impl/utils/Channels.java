package com.binance.client.impl.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.binance.client.model.market.BookDepth;
import com.binance.client.model.market.Candle;

import java.util.List;

public abstract class Channels {

    public static final String OP_SUB = "sub";
    public static final String OP_REQ = "req";

    public static String aggregateTradeChannel(List<String> symbols) {
        JSONObject json = new JSONObject();
        JSONArray params = new JSONArray();
        symbols.forEach(symbol -> params.add(symbol.toLowerCase() + "@aggTrade"));
        json.put("params", params);
        json.put("id", System.currentTimeMillis());
        json.put("method", "SUBSCRIBE");
        return json.toJSONString();
    }

    public static String markPriceChannel(List<String> symbols) {
        JSONObject json = new JSONObject();
        JSONArray params = new JSONArray();
        symbols.forEach(symbol -> params.add(symbol.toLowerCase() + "@markPrice@1s"));
        json.put("params", params);
        json.put("id", System.currentTimeMillis());
        json.put("method", "SUBSCRIBE");
        return json.toJSONString();
    }

    public static String candlestickChannel(List<Candle> candles) {
        JSONObject json = new JSONObject();
        JSONArray params = new JSONArray();
        candles.forEach(candle -> params.add(candle.getSymbol().toLowerCase() + "@kline_" + candle.getInterval()));
        json.put("params", params);
        json.put("id", System.currentTimeMillis());
        json.put("method", "SUBSCRIBE");
        return json.toJSONString();
    }

    public static String miniTickerChannel(List<String> symbols) {
        JSONObject json = new JSONObject();
        JSONArray params = new JSONArray();
        symbols.forEach(symbol -> params.add(symbol.toLowerCase() + "@miniTicker"));
        json.put("params", params);
        json.put("id", System.currentTimeMillis());
        json.put("method", "SUBSCRIBE");
        return json.toJSONString();
    }

    public static String miniTickerChannel() {
        JSONObject json = new JSONObject();
        JSONArray params = new JSONArray();
        params.add("!miniTicker@arr");
        json.put("params", params);
        json.put("id", System.currentTimeMillis());
        json.put("method", "SUBSCRIBE");
        return json.toJSONString();
    }

    public static String tickerChannel(List<String> symbols) {
        JSONObject json = new JSONObject();
        JSONArray params = new JSONArray();
        symbols.forEach(symbol -> params.add(symbol.toLowerCase() + "@ticker"));
        json.put("params", params);
        json.put("id", System.currentTimeMillis());
        json.put("method", "SUBSCRIBE");
        return json.toJSONString();
    }

    public static String tickerChannel() {
        JSONObject json = new JSONObject();
        JSONArray params = new JSONArray();
        params.add("!ticker@arr");
        json.put("params", params);
        json.put("id", System.currentTimeMillis());
        json.put("method", "SUBSCRIBE");
        return json.toJSONString();
    }

    public static String bookTickerChannel(List<String> symbols) {
        JSONObject json = new JSONObject();
        JSONArray params = new JSONArray();
        symbols.forEach(symbol -> params.add(symbol.toLowerCase() + "@bookTicker"));
        json.put("params", params);
        json.put("id", System.currentTimeMillis());
        json.put("method", "SUBSCRIBE");
        return json.toJSONString();
    }

    public static String bookTickerChannel() {
        JSONObject json = new JSONObject();
        JSONArray params = new JSONArray();
        params.add("!bookTicker");
        json.put("params", params);
        json.put("id", System.currentTimeMillis());
        json.put("method", "SUBSCRIBE");
        return json.toJSONString();
    }

    public static String liquidationOrderChannel(List<String> symbols) {
        JSONObject json = new JSONObject();
        JSONArray params = new JSONArray();
        symbols.forEach(symbol -> params.add(symbol.toLowerCase() + "@forceOrder"));
        json.put("params", params);
        json.put("id", System.currentTimeMillis());
        json.put("method", "SUBSCRIBE");
        return json.toJSONString();
    }

    public static String liquidationOrderChannel() {
        JSONObject json = new JSONObject();
        JSONArray params = new JSONArray();
        params.add("!forceOrder@arr");
        json.put("params", params);
        json.put("id", System.currentTimeMillis());
        json.put("method", "SUBSCRIBE");
        return json.toJSONString();
    }

    public static String bookDepthChannel(List<BookDepth> bookDepths) {
        JSONObject json = new JSONObject();
        JSONArray params = new JSONArray();
        bookDepths.forEach(bookDepth -> params.add(bookDepth.getSymbol().toLowerCase() + "@depth" + bookDepth.getLimit()));
        json.put("params", params);
        json.put("id", System.currentTimeMillis());
        json.put("method", "SUBSCRIBE");
        return json.toJSONString();
    }

    public static String diffDepthChannel(List<String> symbols) {
        JSONObject json = new JSONObject();
        JSONArray params = new JSONArray();
        symbols.forEach(symbol -> params.add(symbol.toLowerCase() + "@depth"));
        json.put("params", params);
        json.put("id", System.currentTimeMillis());
        json.put("method", "SUBSCRIBE");
        return json.toJSONString();
    }

    public static String userDataChannel(String listenKey) {
        JSONObject json = new JSONObject();
        JSONArray params = new JSONArray();
        params.add(listenKey);
        json.put("params", params);
        json.put("id", System.currentTimeMillis());
        json.put("method", "SUBSCRIBE");
        return json.toJSONString();
    }

}