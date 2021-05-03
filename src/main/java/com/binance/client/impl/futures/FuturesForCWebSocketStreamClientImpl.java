package com.binance.client.impl.futures;

import com.binance.client.FuturesForCSubscriptionClient;
import com.binance.client.SubscriptionErrorHandler;
import com.binance.client.SubscriptionListener;
import com.binance.client.SubscriptionOptions;
import com.binance.client.constant.BinanceApiConstants;
import com.binance.client.impl.base.WebSocketStreamClientImpl;
import com.binance.client.model.event.LiquidationOrderEvent;
import com.binance.client.model.event.MarkPriceEvent;

public class FuturesForCWebSocketStreamClientImpl extends WebSocketStreamClientImpl implements FuturesForCSubscriptionClient {

    protected String getSubscriptionUrl() {
        return BinanceApiConstants.WS_API_BASE_URL_FUTURES_FOR_C;
    }

    public FuturesForCWebSocketStreamClientImpl(SubscriptionOptions options) {
        super(options);
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
