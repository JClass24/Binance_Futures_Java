package com.binance.client.examples.websocket;

import com.binance.client.exception.BinanceApiException;
import com.binance.client.impl.base.RestApiInvoker;
import com.binance.client.model.enums.CandlestickInterval;
import com.binance.client.model.enums.SymbolType;
import com.binance.client.model.event.SymbolBookTickerEvent;
import com.binance.client.model.market.Candle;
import com.binance.client.websocket.FuturesForUSubscriptionClient;
import com.binance.client.websocket.SubscriptionListener;

import java.util.Arrays;

public class SubscribeCandlestick {

    public static void main(String[] args) {
        RestApiInvoker.initClient("127.0.0.1", 1080, 15);
        FuturesForUSubscriptionClient client = FuturesForUSubscriptionClient.create();
        Candle candle1 = new Candle("btcusdt", SymbolType.FUTURE_U, CandlestickInterval.ONE_MINUTE.code());
        Candle candle2 = new Candle("btcusdt", SymbolType.FUTURE_U, CandlestickInterval.FIVE_MINUTES.code());
//        client.subscribeCandlestickEvent(Arrays.asList(candle1, candle2), ((event) -> {
//            System.out.println(System.currentTimeMillis() + ":" + event);
//            //client.unsubscribeAll();
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
