package com.binance.client.examples.websocket;

import com.binance.client.FuturesForUSubscriptionClient;
import com.binance.client.base.SubscriptionClient;
import com.binance.client.examples.constants.PrivateConfig;

public class SubscribeBookDepth {

    public static void main(String[] args) {

        FuturesForUSubscriptionClient client = FuturesForUSubscriptionClient.create();

        client.subscribeBookDepthEvent("btcusdt", 5, ((event) -> {
            System.out.println(event);
            client.unsubscribeAll();
        }), null);

    }

}
