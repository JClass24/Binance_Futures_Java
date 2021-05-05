package com.binance.client.examples.websocket;

import com.binance.client.websocket.FuturesForUSubscriptionClient;

public class SubscribeAllLiquidationOrder {

    public static void main(String[] args) {

        FuturesForUSubscriptionClient client = FuturesForUSubscriptionClient.create();

        client.subscribeAllLiquidationOrderEvent(((event) -> {
            System.out.println(event);
        }), null);

    }

}
