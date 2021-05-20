package com.binance.client.examples.websocket;

import com.binance.client.exception.BinanceApiException;
import com.binance.client.model.event.AggregateTradeEvent;
import com.binance.client.websocket.FuturesForUSubscriptionClient;
import com.binance.client.websocket.SubscriptionListener;

import java.util.Arrays;

public class SubscribeAggregateTrade {

    public static void main(String[] args) {

        FuturesForUSubscriptionClient client = FuturesForUSubscriptionClient.create();

        client.subscribeAggregateTradeEvent(Arrays.asList("btcusdt"), new SubscriptionListener<AggregateTradeEvent>() {
                    @Override
                    public void onReceive(AggregateTradeEvent event) {
                        System.out.println(event);
                        client.unsubscribeAll();
                    }

                    @Override
                    public void onError(BinanceApiException exception) {

                    }
                }
        );
    }

}
