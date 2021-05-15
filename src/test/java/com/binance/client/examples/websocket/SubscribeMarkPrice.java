package com.binance.client.examples.websocket;

import com.binance.client.impl.base.RestApiInvoker;
import com.binance.client.websocket.FuturesForUSubscriptionClient;

import java.util.Arrays;

public class SubscribeMarkPrice {

    public static void main(String[] args) {
        RestApiInvoker.initClient("127.0.0.1", 1080, 15);
        FuturesForUSubscriptionClient client = FuturesForUSubscriptionClient.create();

        client.subscribeMarkPriceEvent(Arrays.asList("btcusdt"), ((event) -> {
            System.out.println(event);
            //client.unsubscribeAll();
        }), null);

    }

}
