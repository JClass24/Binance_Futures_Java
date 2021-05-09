package com.binance.client.examples.trade;

import com.binance.client.RequestOptions;
import com.binance.client.examples.constants.PrivateConfig;
import com.binance.client.impl.base.RestApiInvoker;
import com.binance.client.model.enums.OrderSide;
import com.binance.client.model.enums.OrderType;
import com.binance.client.model.enums.TimeInForce;
import com.binance.client.rest.SpotSyncRequestClient;

public class PostOrder {
    public static void main(String[] args) {
        RequestOptions options = new RequestOptions();
        //FuturesForUSyncRequestClient syncRequestClient = FuturesForUSyncRequestClient.create(PrivateConfig.API_KEY, PrivateConfig.SECRET_KEY);
        RestApiInvoker.initClient("127.0.0.1", 1080, 15);
        SpotSyncRequestClient syncRequestClient = SpotSyncRequestClient.create(PrivateConfig.API_KEY, PrivateConfig.SECRET_KEY);

//        System.out.println(syncRequestClient.postOrder("BTCUSDT", OrderSide.SELL, PositionSide.BOTH, OrderType.LIMIT, TimeInForce.GTC,
//                "1", "1", null, null, null, null));

        // place dual position side order.
        // Switch between dual or both position side, call: com.binance.client.examples.trade.ChangePositionSide
//        System.out.println(syncRequestClient.postOrder("BTCUSDT", OrderSide.BUY, PositionSide.BOTH, OrderType.LIMIT, TimeInForce.GTC,
//                "0.001", "48065.35", null, null, null, null, NewOrderRespType.RESULT));

        System.out.println(syncRequestClient.postOrder("BTCUSDT", OrderSide.BUY, OrderType.LIMIT, TimeInForce.GTC, "0.001", null, "50000.35", "111", null, null, null));
    }
}