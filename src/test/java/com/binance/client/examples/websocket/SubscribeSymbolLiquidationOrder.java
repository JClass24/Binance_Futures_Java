package com.binance.client.examples.websocket;

import com.binance.client.exception.BinanceApiException;
import com.binance.client.model.event.SymbolBookTickerEvent;
import com.binance.client.websocket.FuturesForUSubscriptionClient;
import com.binance.client.websocket.SubscriptionListener;

import java.util.Arrays;

public class SubscribeSymbolLiquidationOrder {

    public static void main(String[] args) {

        FuturesForUSubscriptionClient client = FuturesForUSubscriptionClient.create();

//        client.subscribeSymbolLiquidationOrderEvent(Arrays.asList("btcusdt"), ((event) -> {
//            System.out.println(event);
//            client.unsubscribeAll();
//        }), null);
//        client.subscribeAllBookTickerEvent(new SubscriptionListener<SymbolBookTickerEvent>() {
//                                               @Override
//                                               public void onReceive(SymbolBookTickerEvent event) {
//                                                   System.out.println(event);
//                                               }
//
//                                               @Override
//                                               public void onError(BinanceApiException exception) {
//
//                                               }
//                                           }
//        );
    }

}
