package com.binance.client.impl.base;

import com.binance.client.base.SubscriptionClient;
import com.binance.client.model.enums.CandlestickInterval;
import com.binance.client.model.event.*;
import com.binance.client.model.user.UserDataUpdateEvent;
import com.binance.client.websocket.SubscriptionErrorHandler;
import com.binance.client.websocket.SubscriptionListener;
import com.binance.client.websocket.SubscriptionOptions;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public abstract class WebSocketStreamClientImpl implements SubscriptionClient {

    protected final WebsocketRequestImpl requestImpl;
    private final SubscriptionOptions options;
    private final List<WebSocketConnection> connections = new LinkedList<>();
    private WebSocketWatchDog watchDog;

    public WebSocketStreamClientImpl(SubscriptionOptions options) {
        this.watchDog = null;
        this.options = Objects.requireNonNull(options);
        this.requestImpl = new WebsocketRequestImpl();
    }

    private <T> void createConnection(WebsocketRequest<T> request, boolean autoClose) {
        if (watchDog == null) {
            watchDog = new WebSocketWatchDog(options);
        }
        WebSocketConnection connection = new WebSocketConnection(request, getSubscriptionUrl(), watchDog,
                autoClose);
        if (!autoClose) {
            connections.add(connection);
        }
        connection.connect();
    }

    protected abstract String getSubscriptionUrl();

    protected <T> void createConnection(WebsocketRequest<T> request) {
        createConnection(request, false);
    }

    @Override
    public void unsubscribeAll() {
        for (WebSocketConnection connection : connections) {
            watchDog.onClosedNormally(connection);
            connection.close();
        }
        connections.clear();
    }

    @Override
    public void subscribeAggregateTradeEvent(String symbol,
                                             SubscriptionListener<AggregateTradeEvent> subscriptionListener,
                                             SubscriptionErrorHandler errorHandler) {
        createConnection(
                requestImpl.subscribeAggregateTradeEvent(symbol, subscriptionListener, errorHandler));
    }

    @Override
    public void subscribeCandlestickEvent(String symbol, CandlestickInterval interval,
                                          SubscriptionListener<CandlestickEvent> subscriptionListener,
                                          SubscriptionErrorHandler errorHandler) {
        createConnection(
                requestImpl.subscribeCandlestickEvent(symbol, interval, subscriptionListener, errorHandler));
    }

    @Override
    public void subscribeSymbolMiniTickerEvent(String symbol,
                                               SubscriptionListener<SymbolMiniTickerEvent> subscriptionListener,
                                               SubscriptionErrorHandler errorHandler) {
        createConnection(
                requestImpl.subscribeSymbolMiniTickerEvent(symbol, subscriptionListener, errorHandler));
    }

    @Override
    public void subscribeAllMiniTickerEvent(SubscriptionListener<List<SymbolMiniTickerEvent>> subscriptionListener,
                                            SubscriptionErrorHandler errorHandler) {
        createConnection(
                requestImpl.subscribeAllMiniTickerEvent(subscriptionListener, errorHandler));
    }

    @Override
    public void subscribeSymbolTickerEvent(String symbol,
                                           SubscriptionListener<SymbolTickerEvent> subscriptionListener,
                                           SubscriptionErrorHandler errorHandler) {
        createConnection(
                requestImpl.subscribeSymbolTickerEvent(symbol, subscriptionListener, errorHandler));
    }

    @Override
    public void subscribeAllTickerEvent(SubscriptionListener<List<SymbolTickerEvent>> subscriptionListener,
                                        SubscriptionErrorHandler errorHandler) {
        createConnection(
                requestImpl.subscribeAllTickerEvent(subscriptionListener, errorHandler));
    }

    @Override
    public void subscribeSymbolBookTickerEvent(String symbol,
                                               SubscriptionListener<SymbolBookTickerEvent> subscriptionListener,
                                               SubscriptionErrorHandler errorHandler) {
        createConnection(
                requestImpl.subscribeSymbolBookTickerEvent(symbol, subscriptionListener, errorHandler));
    }

    @Override
    public void subscribeAllBookTickerEvent(SubscriptionListener<SymbolBookTickerEvent> subscriptionListener,
                                            SubscriptionErrorHandler errorHandler) {
        createConnection(
                requestImpl.subscribeAllBookTickerEvent(subscriptionListener, errorHandler));
    }

    @Override
    public void subscribeBookDepthEvent(String symbol, Integer limit,
                                        SubscriptionListener<OrderBookEvent> subscriptionListener,
                                        SubscriptionErrorHandler errorHandler) {
        createConnection(
                requestImpl.subscribeBookDepthEvent(symbol, limit, subscriptionListener, errorHandler));
    }

    @Override
    public void subscribeDiffDepthEvent(String symbol,
                                        SubscriptionListener<OrderBookEvent> subscriptionListener,
                                        SubscriptionErrorHandler errorHandler) {
        createConnection(
                requestImpl.subscribeDiffDepthEvent(symbol, subscriptionListener, errorHandler));
    }

    @Override
    public void subscribeUserDataEvent(String listenKey,
                                       SubscriptionListener<UserDataUpdateEvent> subscriptionListener,
                                       SubscriptionErrorHandler errorHandler) {
        createConnection(
                requestImpl.subscribeUserDataEvent(listenKey, subscriptionListener, errorHandler));
    }


}
