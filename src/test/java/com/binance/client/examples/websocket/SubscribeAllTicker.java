package com.binance.client.examples.websocket;

import com.binance.client.exception.BinanceApiException;
import com.binance.client.impl.base.RestApiInvoker;
import com.binance.client.model.event.SymbolTickerEvent;
import com.binance.client.websocket.FuturesForUSubscriptionClient;
import com.binance.client.websocket.SubscriptionListener;

import java.util.Arrays;

public class SubscribeAllTicker {

    public static void main(String[] args) {
        RestApiInvoker.initClient("127.0.0.1", 1080, 15);
        FuturesForUSubscriptionClient client = FuturesForUSubscriptionClient.create();

//        client.subscribeAllTickerEvent(((event) -> {
//            System.out.println(event);
//            client.unsubscribeAll();
//        }), null);

        client.subscribeSymbolTickerEvent(Arrays.asList("btcusdt", "ETHUSDT"), new SubscriptionListener<SymbolTickerEvent>() {
                    @Override
                    public void onReceive(SymbolTickerEvent event) {
                        System.out.println(event);
                    }

                    @Override
                    public void onError(BinanceApiException exception) {

                    }

                    @Override
                    public void notice(String msg) {

                    }
                }
        );
//        client.subscribeAllTickerEvent(new SubscriptionListener<List<SymbolTickerEvent>>() {
//                                           @Override
//                                           public void onReceive(List<SymbolTickerEvent> event) {
//                                               System.out.println(event);
//                                           }
//
//                                           @Override
//                                           public void onError(BinanceApiException exception) {
//
//                                           }
//                                       }
//        );
    }

}
