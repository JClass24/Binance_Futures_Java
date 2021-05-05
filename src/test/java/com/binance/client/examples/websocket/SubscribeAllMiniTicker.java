package com.binance.client.examples.websocket;

import com.binance.client.websocket.FuturesForUSubscriptionClient;

public class SubscribeAllMiniTicker {

    public static void main(String[] args) {

        FuturesForUSubscriptionClient client = FuturesForUSubscriptionClient.create();

        client.subscribeAllMiniTickerEvent(((event) -> {
            System.out.println(event);
        }), null);

    }

}
