package com.binance.client.examples.trade;

import com.binance.client.examples.constants.PrivateConfig;
import com.binance.client.rest.FuturesForUSyncRequestClient;

/**
 * @author : wangwanlu
 * @since : 2020/4/23, Thu
 **/
public class GetPositionMarginHistory {

    static int INCREASE_MARGIN_TYPE = 1;
    static int DECREASE_MARGIN_TYPE = 2;

    public static void main(String[] args) {
        FuturesForUSyncRequestClient syncRequestClient = FuturesForUSyncRequestClient.create(PrivateConfig.API_KEY, PrivateConfig.SECRET_KEY);


        long endTime = System.currentTimeMillis();
        long startTime = endTime - (24 * 60 * 60 * 1000);
        int limit = 500;
        System.out.println(syncRequestClient.getPositionMarginHistory("BTCUSDT", INCREASE_MARGIN_TYPE, startTime, endTime, limit));
    }
}
