package com.binance.client.examples.websocket;

import com.binance.client.websocket.FuturesForUSubscriptionClient;

public class SubscribeBookDepth {

    public static void main(String[] args) {

        FuturesForUSubscriptionClient client = FuturesForUSubscriptionClient.create();

        client.subscribeBookDepthEvent("btcusdt", 5, ((event) -> {
            System.out.println(event);
            client.unsubscribeAll();
        }), null);

    }

}
