package com.binance.client.examples.trade;

import com.binance.client.examples.constants.PrivateConfig;
import com.binance.client.rest.FuturesForUSyncRequestClient;

/**
 * @author : wangwanlu
 * @since : 2020/3/25, Wed
 **/
public class ChangePositionSide {
    public static void main(String[] args) {
        FuturesForUSyncRequestClient syncRequestClient = FuturesForUSyncRequestClient.create(PrivateConfig.API_KEY, PrivateConfig.SECRET_KEY);

        System.out.println(syncRequestClient.changePositionSide(true));
    }
}
