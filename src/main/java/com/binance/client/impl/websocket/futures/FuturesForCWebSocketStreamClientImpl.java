package com.binance.client.impl.websocket.futures;

import com.binance.client.constant.BinanceApiConstants;
import com.binance.client.impl.base.WebSocketStreamClientImpl;
import com.binance.client.model.event.LiquidationOrderEvent;
import com.binance.client.model.event.MarkPriceEvent;
import com.binance.client.rest.FuturesForCSyncRequestClient;
import com.binance.client.websocket.FuturesForCSubscriptionClient;
import com.binance.client.websocket.SubscriptionListener;
import com.binance.client.websocket.SubscriptionOptions;

import java.util.List;

public class FuturesForCWebSocketStreamClientImpl extends WebSocketStreamClientImpl implements FuturesForCSubscriptionClient {

    public FuturesForCWebSocketStreamClientImpl(SubscriptionOptions options) {
        super(options);
    }

    protected String getSubscriptionUrl() {
        return BinanceApiConstants.WS_API_BASE_URL_FUTURES_FOR_C;
    }

    @Override
    protected String getListenKey() {
        return FuturesForCSyncRequestClient.create(options.getApiKey(), options.getSecretKey()).startUserDataStream();
    }

    @Override
    public void subscribeMarkPriceEvent(List<String> symbols,
                                        SubscriptionListener<MarkPriceEvent> subscriptionListener) {
        createConnection(
                requestImpl.subscribeMarkPriceEvent(symbols, subscriptionListener));
    }

    @Override
    public void subscribeSymbolLiquidationOrderEvent(List<String> symbols,
                                                     SubscriptionListener<LiquidationOrderEvent> subscriptionListener) {
        createConnection(
                requestImpl.subscribeSymbolLiquidationOrderEvent(symbols, subscriptionListener));
    }

    @Override
    public void subscribeAllLiquidationOrderEvent(SubscriptionListener<LiquidationOrderEvent> subscriptionListener) {
        createConnection(
                requestImpl.subscribeAllLiquidationOrderEvent(subscriptionListener));
    }
}
