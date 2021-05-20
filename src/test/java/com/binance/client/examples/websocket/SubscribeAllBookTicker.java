package com.binance.client.examples.websocket;

import com.binance.client.exception.BinanceApiException;
import com.binance.client.model.event.SymbolBookTickerEvent;
import com.binance.client.websocket.FuturesForUSubscriptionClient;
import com.binance.client.websocket.SubscriptionListener;

public class SubscribeAllBookTicker {

    public static void main(String[] args) {

        FuturesForUSubscriptionClient client = FuturesForUSubscriptionClient.create();
        client.subscribeAllBookTickerEvent(new SubscriptionListener<SymbolBookTickerEvent>() {
                                               @Override
                                               public void onReceive(SymbolBookTickerEvent event) {
                                                   System.out.println(event);
                                               }

                                               @Override
                                               public void onError(BinanceApiException exception) {

                                               }
                                           }
        );
    }

}
