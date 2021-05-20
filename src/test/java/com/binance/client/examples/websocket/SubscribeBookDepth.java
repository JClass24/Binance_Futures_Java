package com.binance.client.examples.websocket;

import com.binance.client.exception.BinanceApiException;
import com.binance.client.model.event.SymbolBookTickerEvent;
import com.binance.client.model.market.BookDepth;
import com.binance.client.websocket.FuturesForUSubscriptionClient;
import com.binance.client.websocket.SubscriptionListener;

import java.util.Arrays;

public class SubscribeBookDepth {

    public static void main(String[] args) {

        FuturesForUSubscriptionClient client = FuturesForUSubscriptionClient.create();
        BookDepth bookDepth = new BookDepth("btcusdt", 5);
//        client.subscribeBookDepthEvent(Arrays.asList(bookDepth), ((event) -> {
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
