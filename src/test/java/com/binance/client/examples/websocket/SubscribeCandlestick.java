package com.binance.client.examples.websocket;

import com.binance.client.model.enums.CandlestickInterval;
import com.binance.client.websocket.FuturesForUSubscriptionClient;

public class SubscribeCandlestick {

    public static void main(String[] args) {

        FuturesForUSubscriptionClient client = FuturesForUSubscriptionClient.create();
        client.subscribeCandlestickEvent("btcusdt", CandlestickInterval.ONE_MINUTE, ((event) -> {
            System.out.println(System.currentTimeMillis() + ":" + event);
            //client.unsubscribeAll();
        }), null);
        client.subscribeCandlestickEvent("eosusdt", CandlestickInterval.ONE_MINUTE, ((event) -> {
            System.out.println(System.currentTimeMillis() + ":" + event);
            //client.unsubscribeAll();
        }), null);
        client.subscribeCandlestickEvent("xrpusdt", CandlestickInterval.ONE_MINUTE, ((event) -> {
            System.out.println(System.currentTimeMillis() + ":" + event);
            //client.unsubscribeAll();
        }), null);
        client.subscribeCandlestickEvent("dotusdt", CandlestickInterval.ONE_MINUTE, ((event) -> {
            System.out.println(System.currentTimeMillis() + ":" + event);
            //client.unsubscribeAll();
        }), null);
        client.subscribeCandlestickEvent("ethusdt", CandlestickInterval.ONE_MINUTE, ((event) -> {
            System.out.println(System.currentTimeMillis() + ":" + event);
            //client.unsubscribeAll();
        }), null);
        client.subscribeCandlestickEvent("bnbusdt", CandlestickInterval.ONE_MINUTE, ((event) -> {
            System.out.println(System.currentTimeMillis() + ":" + event);
            //client.unsubscribeAll();
        }), null);
        client.subscribeCandlestickEvent("dogeusdt", CandlestickInterval.ONE_MINUTE, ((event) -> {
            System.out.println(System.currentTimeMillis() + ":" + event);
            //client.unsubscribeAll();
        }), null);
        client.subscribeCandlestickEvent("btcusdt", CandlestickInterval.FIVE_MINUTES, ((event) -> {
            System.out.println(System.currentTimeMillis() + ":" + event);
            //client.unsubscribeAll();
        }), null);
        client.subscribeCandlestickEvent("eosusdt", CandlestickInterval.FIVE_MINUTES, ((event) -> {
            System.out.println(System.currentTimeMillis() + ":" + event);
            //client.unsubscribeAll();
        }), null);
        client.subscribeCandlestickEvent("xrpusdt", CandlestickInterval.FIVE_MINUTES, ((event) -> {
            System.out.println(System.currentTimeMillis() + ":" + event);
            //client.unsubscribeAll();
        }), null);
        client.subscribeCandlestickEvent("dotusdt", CandlestickInterval.FIVE_MINUTES, ((event) -> {
            System.out.println(System.currentTimeMillis() + ":" + event);
            //client.unsubscribeAll();
        }), null);
        client.subscribeCandlestickEvent("ethusdt", CandlestickInterval.FIVE_MINUTES, ((event) -> {
            System.out.println(System.currentTimeMillis() + ":" + event);
            //client.unsubscribeAll();
        }), null);
        client.subscribeCandlestickEvent("bnbusdt", CandlestickInterval.FIVE_MINUTES, ((event) -> {
            System.out.println(System.currentTimeMillis() + ":" + event);
            //client.unsubscribeAll();
        }), null);
        client.subscribeCandlestickEvent("dogeusdt", CandlestickInterval.FIVE_MINUTES, ((event) -> {
            System.out.println(System.currentTimeMillis() + ":" + event);
            //client.unsubscribeAll();
        }), null);
        client.subscribeCandlestickEvent("btcusdt", CandlestickInterval.HALF_HOURLY, ((event) -> {
            System.out.println(System.currentTimeMillis() + ":" + event);
            //client.unsubscribeAll();
        }), null);
        client.subscribeCandlestickEvent("eosusdt", CandlestickInterval.HALF_HOURLY, ((event) -> {
            System.out.println(System.currentTimeMillis() + ":" + event);
            //client.unsubscribeAll();
        }), null);
        client.subscribeCandlestickEvent("xrpusdt", CandlestickInterval.HALF_HOURLY, ((event) -> {
            System.out.println(System.currentTimeMillis() + ":" + event);
            //client.unsubscribeAll();
        }), null);
        client.subscribeCandlestickEvent("dotusdt", CandlestickInterval.HALF_HOURLY, ((event) -> {
            System.out.println(System.currentTimeMillis() + ":" + event);
            //client.unsubscribeAll();
        }), null);
        client.subscribeCandlestickEvent("ethusdt", CandlestickInterval.HALF_HOURLY, ((event) -> {
            System.out.println(System.currentTimeMillis() + ":" + event);
            //client.unsubscribeAll();
        }), null);
        client.subscribeCandlestickEvent("bnbusdt", CandlestickInterval.HALF_HOURLY, ((event) -> {
            System.out.println(System.currentTimeMillis() + ":" + event);
            //client.unsubscribeAll();
        }), null);
        client.subscribeCandlestickEvent("dogeusdt", CandlestickInterval.HALF_HOURLY, ((event) -> {
            System.out.println(System.currentTimeMillis() + ":" + event);
            //client.unsubscribeAll();
        }), null);

    }

}
