package com.binance.client.examples.trade;

import com.binance.client.examples.constants.PrivateConfig;
import com.binance.client.impl.base.RestApiInvoker;
import com.binance.client.rest.FuturesForUSyncRequestClient;

public class GetAccountInformation {
    public static void main(String[] args) {
        RestApiInvoker.initClient("127.0.0.1", 1080, 15);
        FuturesForUSyncRequestClient syncRequestClient = FuturesForUSyncRequestClient.create(PrivateConfig.API_KEY, PrivateConfig.SECRET_KEY);

        System.out.println(syncRequestClient.getAccountInformation());
    }
}