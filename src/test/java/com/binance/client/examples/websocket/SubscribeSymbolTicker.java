package com.binance.client.examples.websocket;

import com.binance.client.websocket.FuturesForUSubscriptionClient;

public class SubscribeSymbolTicker {

    public static void main(String[] args) {

        FuturesForUSubscriptionClient client = FuturesForUSubscriptionClient.create();

//        client.subscribeSymbolTickerEvent(Arrays.asList("btcusdt"), ((event) -> {
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
