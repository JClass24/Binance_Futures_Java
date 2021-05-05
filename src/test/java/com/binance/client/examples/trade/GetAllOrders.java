package com.binance.client.examples.trade;

import com.binance.client.examples.constants.PrivateConfig;
import com.binance.client.rest.FuturesForUSyncRequestClient;

public class GetAllOrders {
    public static void main(String[] args) {
        FuturesForUSyncRequestClient syncRequestClient = FuturesForUSyncRequestClient.create(PrivateConfig.API_KEY, PrivateConfig.SECRET_KEY);

        System.out.println(syncRequestClient.getAllOrders("BTCUSDT", null, null, null, 10));
        // System.out.println(syncRequestClient.getAllOrders("BTCUSDT", null, null, null, null));
    }
}