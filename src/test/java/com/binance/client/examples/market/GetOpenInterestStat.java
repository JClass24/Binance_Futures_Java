package com.binance.client.examples.market;

import com.binance.client.examples.constants.PrivateConfig;
import com.binance.client.model.enums.PeriodType;
import com.binance.client.rest.FuturesForUSyncRequestClient;

public class GetOpenInterestStat {
    public static void main(String[] args) {
        FuturesForUSyncRequestClient syncRequestClient = FuturesForUSyncRequestClient.create(PrivateConfig.API_KEY, PrivateConfig.SECRET_KEY);

        System.out.println(syncRequestClient.getOpenInterestStat("BTCUSDT", PeriodType._5m, null, null, 10));


    }
}
