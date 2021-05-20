package com.binance.client.examples.websocket;

import com.binance.client.exception.BinanceApiException;
import com.binance.client.model.event.LiquidationOrderEvent;
import com.binance.client.websocket.FuturesForUSubscriptionClient;
import com.binance.client.websocket.SubscriptionListener;

public class SubscribeAllLiquidationOrder {

    public static void main(String[] args) {

        FuturesForUSubscriptionClient client = FuturesForUSubscriptionClient.create();

        client.subscribeAllLiquidationOrderEvent(new SubscriptionListener<LiquidationOrderEvent>() {
                                                     @Override
                                                     public void onReceive(LiquidationOrderEvent event) {
                                                         System.out.println(event);
                                                     }

                                                     @Override
                                                     public void onError(BinanceApiException exception) {

                                                     }
                                                 }
        );
    }

}
