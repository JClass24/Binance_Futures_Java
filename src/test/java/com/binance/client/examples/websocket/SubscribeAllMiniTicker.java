package com.binance.client.examples.websocket;

import com.binance.client.exception.BinanceApiException;
import com.binance.client.model.event.SymbolBookTickerEvent;
import com.binance.client.websocket.FuturesForUSubscriptionClient;
import com.binance.client.websocket.SubscriptionListener;

public class SubscribeAllMiniTicker {

    public static void main(String[] args) {

        FuturesForUSubscriptionClient client = FuturesForUSubscriptionClient.create();

//        client.subscribeAllMiniTickerEvent(((event) -> {
//            System.out.println(event);
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
