package com.binance.client.examples.trade;

import com.binance.client.RequestOptions;
import com.binance.client.examples.constants.PrivateConfig;
import com.binance.client.model.enums.*;
import com.binance.client.rest.FuturesForUSyncRequestClient;

public class PostOrder {
    public static void main(String[] args) {
        RequestOptions options = new RequestOptions();
        FuturesForUSyncRequestClient syncRequestClient = FuturesForUSyncRequestClient.create(PrivateConfig.API_KEY, PrivateConfig.SECRET_KEY);

//        System.out.println(syncRequestClient.postOrder("BTCUSDT", OrderSide.SELL, PositionSide.BOTH, OrderType.LIMIT, TimeInForce.GTC,
//                "1", "1", null, null, null, null));

        // place dual position side order.
        // Switch between dual or both position side, call: com.binance.client.examples.trade.ChangePositionSide
        System.out.println(syncRequestClient.postOrder("BTCUSDT", OrderSide.SELL, PositionSide.SHORT, OrderType.LIMIT, TimeInForce.GTC,
                "1", "9000", null, null, null, null, NewOrderRespType.RESULT));
    }
}