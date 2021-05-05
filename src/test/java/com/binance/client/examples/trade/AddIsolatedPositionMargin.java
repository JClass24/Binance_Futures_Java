package com.binance.client.examples.trade;

import com.binance.client.examples.constants.PrivateConfig;
import com.binance.client.model.enums.PositionSide;
import com.binance.client.rest.FuturesForUSyncRequestClient;

/**
 * @author : wangwanlu
 * @since : 2020/4/23, Thu
 **/
public class AddIsolatedPositionMargin {

    static int INCREASE_MARGIN_TYPE = 1;
    static int DECREASE_MARGIN_TYPE = 2;

    public static void main(String[] args) {
        FuturesForUSyncRequestClient syncRequestClient = FuturesForUSyncRequestClient.create(PrivateConfig.API_KEY, PrivateConfig.SECRET_KEY);


        System.out.println(syncRequestClient.addIsolatedPositionMargin("BTCUSDT", INCREASE_MARGIN_TYPE, "100", PositionSide.BOTH));
    }
}
