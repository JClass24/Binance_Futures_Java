package com.binance.client.impl.base;

import com.binance.client.impl.utils.Handler;
import com.binance.client.websocket.SubscriptionErrorHandler;
import com.binance.client.websocket.SubscriptionListener;

class WebsocketRequest<T> {

    final SubscriptionListener<T> updateCallback;
    final SubscriptionErrorHandler errorHandler;
    String signatureVersion = "2";
    String name;
    Handler<WebSocketConnection> connectionHandler;
    Handler<WebSocketConnection> authHandler = null;
    RestApiJsonParser<T> jsonParser;

    WebsocketRequest(SubscriptionListener<T> listener, SubscriptionErrorHandler errorHandler) {
        this.updateCallback = listener;
        this.errorHandler = errorHandler;
    }
}
