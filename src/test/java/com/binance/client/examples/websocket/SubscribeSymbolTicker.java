package com.binance.client.examples.websocket;

import com.binance.client.websocket.FuturesForUSubscriptionClient;

import java.util.Arrays;

public class SubscribeSymbolTicker {

    public static void main(String[] args) {

        FuturesForUSubscriptionClient client = FuturesForUSubscriptionClient.create();

        client.subscribeSymbolTickerEvent(Arrays.asList("btcusdt"), ((event) -> {
            System.out.println(event);
            client.unsubscribeAll();
        }), null);

    }

}
