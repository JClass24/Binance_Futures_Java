package com.binance.client.impl.base;

import com.binance.client.base.SubscriptionClient;
import com.binance.client.model.event.*;
import com.binance.client.model.market.BookDepth;
import com.binance.client.model.market.CandleConfig;
import com.binance.client.model.user.UserDataUpdateEvent;
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
                                             SubscriptionListener<AggregateTradeEvent> subscriptionListener) {
        createConnection(
                requestImpl.subscribeAggregateTradeEvent(symbols, subscriptionListener));
    }

    @Override
    public void subscribeCandlestickEvent(List<CandleConfig> CandleConfigs,
                                          SubscriptionListener<CandlestickEvent> subscriptionListener) {
        createConnection(
                requestImpl.subscribeCandlestickEvent(CandleConfigs, subscriptionListener));
    }

    @Override
    public void subscribeSymbolMiniTickerEvent(List<String> symbols,
                                               SubscriptionListener<SymbolMiniTickerEvent> subscriptionListener) {
        createConnection(
                requestImpl.subscribeSymbolMiniTickerEvent(symbols, subscriptionListener));
    }

    @Override
    public void subscribeAllMiniTickerEvent(SubscriptionListener<List<SymbolMiniTickerEvent>> subscriptionListener) {
        createConnection(
                requestImpl.subscribeAllMiniTickerEvent(subscriptionListener));
    }

    @Override
    public void subscribeSymbolTickerEvent(List<String> symbols,
                                           SubscriptionListener<SymbolTickerEvent> subscriptionListener) {
        createConnection(
                requestImpl.subscribeSymbolTickerEvent(symbols, subscriptionListener));
    }

    @Override
    public void subscribeAllTickerEvent(SubscriptionListener<List<SymbolTickerEvent>> subscriptionListener) {
        createConnection(
                requestImpl.subscribeAllTickerEvent(subscriptionListener));
    }

    @Override
    public void subscribeSymbolBookTickerEvent(List<String> symbols,
                                               SubscriptionListener<SymbolBookTickerEvent> subscriptionListener) {
        createConnection(
                requestImpl.subscribeSymbolBookTickerEvent(symbols, subscriptionListener));
    }

    @Override
    public void subscribeAllBookTickerEvent(SubscriptionListener<SymbolBookTickerEvent> subscriptionListener) {
        createConnection(
                requestImpl.subscribeAllBookTickerEvent(subscriptionListener));
    }

    @Override
    public void subscribeBookDepthEvent(List<BookDepth> bookDepths,
                                        SubscriptionListener<OrderBookEvent> subscriptionListener) {
        createConnection(
                requestImpl.subscribeBookDepthEvent(bookDepths, subscriptionListener));
    }

    @Override
    public void subscribeDiffDepthEvent(List<String> symbols,
                                        SubscriptionListener<OrderBookEvent> subscriptionListener) {
        createConnection(
                requestImpl.subscribeDiffDepthEvent(symbols, subscriptionListener));
    }

    @Override
    public void subscribeUserDataEvent(SubscriptionListener<UserDataUpdateEvent> subscriptionListener) {
        if (options.getListenKey() == null) {
            options.setListenKey(getListenKey());
        }
        createConnection(
                requestImpl.subscribeUserDataEvent(options.getListenKey(), subscriptionListener));
    }

    protected abstract String getListenKey();
}
