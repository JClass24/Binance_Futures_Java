package com.binance.client.examples.market;

import com.binance.client.examples.constants.PrivateConfig;
import com.binance.client.rest.FuturesForCSyncRequestClient;

public class GetExchangeInformation {
    public static void main(String[] args) {
        FuturesForCSyncRequestClient syncRequestClient = FuturesForCSyncRequestClient.create(PrivateConfig.API_KEY, PrivateConfig.SECRET_KEY);

        System.out.println(syncRequestClient.getExchangeInformation());
    }
}
