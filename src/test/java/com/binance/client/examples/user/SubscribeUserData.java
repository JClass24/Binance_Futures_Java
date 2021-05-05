package com.binance.client.examples.user;

import com.binance.client.examples.constants.PrivateConfig;
import com.binance.client.rest.FuturesForUSyncRequestClient;
import com.binance.client.websocket.FuturesForUSubscriptionClient;

public class SubscribeUserData {

    public static void main(String[] args) {

        FuturesForUSyncRequestClient syncRequestClient = FuturesForUSyncRequestClient.create(PrivateConfig.API_KEY, PrivateConfig.SECRET_KEY);


        // Start user data stream
        String listenKey = syncRequestClient.startUserDataStream();
        System.out.println("listenKey: " + listenKey);

        // Keep user data stream
        syncRequestClient.keepUserDataStream(listenKey);

        // Close user data stream
        syncRequestClient.closeUserDataStream(listenKey);

        FuturesForUSubscriptionClient client = FuturesForUSubscriptionClient.create();


        client.subscribeUserDataEvent(listenKey, ((event) -> {
            System.out.println(event);
        }), null);

    }

}