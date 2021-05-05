package com.binance.client.examples.market;

import com.binance.client.examples.constants.PrivateConfig;
import com.binance.client.rest.FuturesForUSyncRequestClient;

public class Get24hrTickerPriceChange {
    public static void main(String[] args) {
        FuturesForUSyncRequestClient syncRequestClient = FuturesForUSyncRequestClient.create(PrivateConfig.API_KEY, PrivateConfig.SECRET_KEY);

        System.out.println(syncRequestClient.get24hrTickerPriceChange("BTCUSDT"));
        // System.out.println(syncRequestClient.get24hrTickerPriceChange(null));
    }
}
