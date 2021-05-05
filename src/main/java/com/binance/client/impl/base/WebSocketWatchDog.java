package com.binance.client.impl.base;

import com.binance.client.impl.base.WebSocketConnection.ConnectionState;
import com.binance.client.websocket.SubscriptionOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class WebSocketWatchDog {

    private static final Logger log = LoggerFactory.getLogger(WebSocketConnection.class);
    private final CopyOnWriteArrayList<WebSocketConnection> TIME_HELPER = new CopyOnWriteArrayList<>();
    private final SubscriptionOptions options;

    WebSocketWatchDog(SubscriptionOptions subscriptionOptions, WebSocketStreamClientImpl webSocketStreamClient) {
        this.options = Objects.requireNonNull(subscriptionOptions);
        long t = 1_000;
        int refresh = 2400;
        AtomicInteger refreshListenKeyCount = new AtomicInteger(refresh);
        ScheduledExecutorService exec = Executors.newScheduledThreadPool(1);
        exec.scheduleAtFixedRate(() -> {
            if (refreshListenKeyCount.getAndDecrement() == 0 && options.getListenKey() != null) {
                options.setListenKey(webSocketStreamClient.getListenKey());
                log.info("refresh listenkey......." + options.getListenKey());
                refreshListenKeyCount.set(refresh);
            }

            TIME_HELPER.forEach(connection -> {
                if (connection.getState() == ConnectionState.CONNECTED) {
                    // Check response
                    if (options.isAutoReconnect()) {
                        long ts = System.currentTimeMillis() - connection.getLastReceivedTime();
                        if (options.getReceiveLimitMs() != -1 && ts > options.getReceiveLimitMs()) {
                            log.warn("[Sub][" + connection.getConnectionId() + "] No response from server");
                            connection.reConnect(options.getConnectionDelayOnFailure());
                        }
                    }
                } else if (connection.getState() == ConnectionState.DELAY_CONNECT) {
                    connection.reConnect();
                } else if (connection.getState() == ConnectionState.CLOSED_ON_ERROR) {
                    if (options.isAutoReconnect()) {
                        connection.reConnect(options.getConnectionDelayOnFailure());
                    }
                }
            });
        }, t, t, TimeUnit.MILLISECONDS);
        Runtime.getRuntime().addShutdownHook(new Thread(exec::shutdown));
    }

    void onConnectionCreated(WebSocketConnection connection) {
        TIME_HELPER.addIfAbsent(connection);
    }

    void onClosedNormally(WebSocketConnection connection) {
        TIME_HELPER.remove(connection);
    }
}
