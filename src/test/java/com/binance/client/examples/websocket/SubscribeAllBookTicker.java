package com.binance.client.examples.websocket;

import com.binance.client.FuturesForUSubscriptionClient;
import com.binance.client.base.SubscriptionClient;
import com.binance.client.examples.constants.PrivateConfig;

public class SubscribeAllBookTicker {

    public static void main(String[] args) {

        FuturesForUSubscriptionClient client = FuturesForUSubscriptionClient.create();

        client.subscribeAllBookTickerEvent(((event) -> {
            System.out.println(event);
        }), null);

    }

}
