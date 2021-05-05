package com.binance.client.examples.websocket;

import com.binance.client.websocket.FuturesForUSubscriptionClient;

public class SubscribeMarkPrice {

    public static void main(String[] args) {

        FuturesForUSubscriptionClient client = FuturesForUSubscriptionClient.create();

        client.subscribeMarkPriceEvent("btcusdt", ((event) -> {
            System.out.println(event);
            client.unsubscribeAll();
        }), null);

    }

}
