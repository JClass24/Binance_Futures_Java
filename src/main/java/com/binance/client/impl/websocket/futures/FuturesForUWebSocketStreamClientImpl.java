package com.binance.client.impl.websocket.futures;

import com.binance.client.constant.BinanceApiConstants;
import com.binance.client.impl.base.WebSocketStreamClientImpl;
import com.binance.client.model.event.LiquidationOrderEvent;
import com.binance.client.model.event.MarkPriceEvent;
import com.binance.client.websocket.FuturesForUSubscriptionClient;
import com.binance.client.websocket.SubscriptionErrorHandler;
import com.binance.client.websocket.SubscriptionListener;
import com.binance.client.websocket.SubscriptionOptions;

public class FuturesForUWebSocketStreamClientImpl extends WebSocketStreamClientImpl implements FuturesForUSubscriptionClient {

    public FuturesForUWebSocketStreamClientImpl(SubscriptionOptions options) {
        super(options);
    }

    protected String getSubscriptionUrl() {
        return BinanceApiConstants.WS_API_BASE_URL_FUTURES_FOR_U;
    }

    @Override
    public void subscribeMarkPriceEvent(String symbol,
                                        SubscriptionListener<MarkPriceEvent> subscriptionListener,
                                        SubscriptionErrorHandler errorHandler) {
        createConnection(
                requestImpl.subscribeMarkPriceEvent(symbol, subscriptionListener, errorHandler));
    }

    @Override
    public void subscribeSymbolLiquidationOrderEvent(String symbol,
                                                     SubscriptionListener<LiquidationOrderEvent> subscriptionListener,
                                                     SubscriptionErrorHandler errorHandler) {
        createConnection(
                requestImpl.subscribeSymbolLiquidationOrderEvent(symbol, subscriptionListener, errorHandler));
    }

    @Override
    public void subscribeAllLiquidationOrderEvent(SubscriptionListener<LiquidationOrderEvent> subscriptionListener,
                                                  SubscriptionErrorHandler errorHandler) {
        createConnection(
                requestImpl.subscribeAllLiquidationOrderEvent(subscriptionListener, errorHandler));
    }
}
