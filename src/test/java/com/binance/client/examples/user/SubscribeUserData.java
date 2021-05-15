package com.binance.client.examples.user;

import com.binance.client.examples.constants.PrivateConfig;
import com.binance.client.impl.base.RestApiInvoker;
import com.binance.client.websocket.FuturesForUSubscriptionClient;
import com.binance.client.websocket.SpotSubscriptionClient;

public class SubscribeUserData {

    public static void main(String[] args) {

//        FuturesForUSyncRequestClient syncRequestClient = FuturesForUSyncRequestClient.create(PrivateConfig.API_KEY, PrivateConfig.SECRET_KEY);
//
//
//        // Start user data stream
//        String listenKey = syncRequestClient.startUserDataStream();
//        System.out.println("listenKey: " + listenKey);
//
//        // Keep user data stream
//        syncRequestClient.keepUserDataStream(listenKey);
//
//        // Close user data stream
//        syncRequestClient.closeUserDataStream(listenKey);
        RestApiInvoker.initClient("127.0.0.1", 1080, 15);
        FuturesForUSubscriptionClient client = FuturesForUSubscriptionClient.create(PrivateConfig.API_KEY, PrivateConfig.SECRET_KEY);
        //SpotSubscriptionClient client = SpotSubscriptionClient.create(PrivateConfig.API_KEY, PrivateConfig.SECRET_KEY);
        //FuturesForCSubscriptionClient client = FuturesForCSubscriptionClient.create(PrivateConfig.API_KEY, PrivateConfig.SECRET_KEY);
//

        client.subscribeUserDataEvent(((event) -> {
            System.out.println(event);
        }), null);

    }

}