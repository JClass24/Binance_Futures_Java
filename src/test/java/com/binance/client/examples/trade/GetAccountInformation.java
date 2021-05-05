package com.binance.client.examples.trade;

import com.binance.client.examples.constants.PrivateConfig;
import com.binance.client.rest.SpotSyncRequestClient;

public class GetAccountInformation {
    public static void main(String[] args) {
        SpotSyncRequestClient syncRequestClient = SpotSyncRequestClient.create(PrivateConfig.API_KEY, PrivateConfig.SECRET_KEY);

        System.out.println(syncRequestClient.getAccountInformation());
    }
}