package com.binance.client.examples.websocket;

import com.binance.client.websocket.FuturesForUSubscriptionClient;

public class SubscribeAllTicker {

    public static void main(String[] args) {

        FuturesForUSubscriptionClient client = FuturesForUSubscriptionClient.create();

        client.subscribeAllTickerEvent(((event) -> {
            System.out.println(event);
            client.unsubscribeAll();
        }), null);

    }

}
