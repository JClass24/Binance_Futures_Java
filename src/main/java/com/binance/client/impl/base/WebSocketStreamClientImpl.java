package com.binance.client.impl.base;

import com.binance.client.base.SubscriptionClient;
import com.binance.client.model.event.*;
import com.binance.client.model.market.BookDepth;
import com.binance.client.model.market.Candle;
import com.binance.client.model.user.UserDataUpdateEvent;
import com.binance.client.websocket.SubscriptionErrorHandler;
import com.binance.client.websocket.SubscriptionListener;
import com.binance.client.websocket.SubscriptionOptions;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public abstract class WebSocketStreamClientImpl implements SubscriptionClient {

    protected final WebsocketRequestImpl requestImpl;
    protected final SubscriptionOptions options;
    private final List<WebSocketConnection> connections = new LinkedList<>();
    private WebSocketWatchDog watchDog;

    public WebSocketStreamClientImpl(SubscriptionOptions options) {
        this.watchDog = null;
        this.options = Objects.requireNonNull(options);
        this.requestImpl = new WebsocketRequestImpl();
    }

    private <T> void createConnection(WebsocketRequest<T> request, boolean autoClose) {
        if (watchDog == null) {
            watchDog = new WebSocketWatchDog(options, this);
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
    public void subscribeAggregateTradeEvent(List<String> symbols,
                                             SubscriptionListener<AggregateTradeEvent> subscriptionListener,
                                             SubscriptionErrorHandler errorHandler) {
        createConnection(
                requestImpl.subscribeAggregateTradeEvent(symbols, subscriptionListener, errorHandler));
    }

    @Override
    public void subscribeCandlestickEvent(List<Candle> candles,
                                          SubscriptionListener<CandlestickEvent> subscriptionListener,
                                          SubscriptionErrorHandler errorHandler) {
        createConnection(
                requestImpl.subscribeCandlestickEvent(candles, subscriptionListener, errorHandler));
    }

    @Override
    public void subscribeSymbolMiniTickerEvent(List<String> symbols,
                                               SubscriptionListener<SymbolMiniTickerEvent> subscriptionListener,
                                               SubscriptionErrorHandler errorHandler) {
        createConnection(
                requestImpl.subscribeSymbolMiniTickerEvent(symbols, subscriptionListener, errorHandler));
    }

    @Override
    public void subscribeAllMiniTickerEvent(SubscriptionListener<List<SymbolMiniTickerEvent>> subscriptionListener,
                                            SubscriptionErrorHandler errorHandler) {
        createConnection(
                requestImpl.subscribeAllMiniTickerEvent(subscriptionListener, errorHandler));
    }

    @Override
    public void subscribeSymbolTickerEvent(List<String> symbols,
                                           SubscriptionListener<SymbolTickerEvent> subscriptionListener,
                                           SubscriptionErrorHandler errorHandler) {
        createConnection(
                requestImpl.subscribeSymbolTickerEvent(symbols, subscriptionListener, errorHandler));
    }

    @Override
    public void subscribeAllTickerEvent(SubscriptionListener<List<SymbolTickerEvent>> subscriptionListener,
                                        SubscriptionErrorHandler errorHandler) {
        createConnection(
                requestImpl.subscribeAllTickerEvent(subscriptionListener, errorHandler));
    }

    @Override
    public void subscribeSymbolBookTickerEvent(List<String> symbols,
                                               SubscriptionListener<SymbolBookTickerEvent> subscriptionListener,
                                               SubscriptionErrorHandler errorHandler) {
        createConnection(
                requestImpl.subscribeSymbolBookTickerEvent(symbols, subscriptionListener, errorHandler));
    }

    @Override
    public void subscribeAllBookTickerEvent(SubscriptionListener<SymbolBookTickerEvent> subscriptionListener,
                                            SubscriptionErrorHandler errorHandler) {
        createConnection(
                requestImpl.subscribeAllBookTickerEvent(subscriptionListener, errorHandler));
    }

    @Override
    public void subscribeBookDepthEvent(List<BookDepth> bookDepths,
                                        SubscriptionListener<OrderBookEvent> subscriptionListener,
                                        SubscriptionErrorHandler errorHandler) {
        createConnection(
                requestImpl.subscribeBookDepthEvent(bookDepths, subscriptionListener, errorHandler));
    }

    @Override
    public void subscribeDiffDepthEvent(List<String> symbols,
                                        SubscriptionListener<OrderBookEvent> subscriptionListener,
                                        SubscriptionErrorHandler errorHandler) {
        createConnection(
                requestImpl.subscribeDiffDepthEvent(symbols, subscriptionListener, errorHandler));
    }

    @Override
    public void subscribeUserDataEvent(SubscriptionListener<UserDataUpdateEvent> subscriptionListener,
                                       SubscriptionErrorHandler errorHandler) {
        if (options.getListenKey() == null) {
            options.setListenKey(getListenKey());
        }
        createConnection(
                requestImpl.subscribeUserDataEvent(options.getListenKey(), subscriptionListener, errorHandler));
    }

    protected abstract String getListenKey();
}
