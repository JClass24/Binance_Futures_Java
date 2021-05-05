package com.binance.client.websocket;

/**
 * The configuration for the subscription APIs
 */
public class SubscriptionOptions {

    private boolean isAutoReconnect = true;
    //-1代表不检测
    private int receiveLimitMs = -1;
    private int connectionDelayOnFailure = 3;
    private String apiKey;
    private String secretKey;
    private String listenKey;

    public SubscriptionOptions() {
    }

    public SubscriptionOptions(SubscriptionOptions options) {
        this.isAutoReconnect = options.isAutoReconnect;
        this.receiveLimitMs = options.receiveLimitMs;
        this.connectionDelayOnFailure = options.connectionDelayOnFailure;
        this.apiKey = options.apiKey;
        this.secretKey = options.secretKey;
        this.listenKey = options.listenKey;
    }

    public SubscriptionOptions(String apiKey, String secretKey) {
        this.apiKey = apiKey;
        this.secretKey = secretKey;
    }

    public boolean isAutoReconnect() {
        return isAutoReconnect;
    }

    /**
     * When the connection lost is happening on the subscription line, specify whether the client reconnect to server
     * automatically.
     * <p>
     * The connection lost means: <ul> <li>Caused by network problem</li> <li>The connection close triggered by server
     * (happened every 24 hours)</li> <li>No any message can be received from server within a specified time, see {@link
     * #setReceiveLimitMs(int)} (int)}</li> </ul>
     *
     * @param isAutoReconnect The boolean flag, true for enable, false for disable
     * @return Return self for chaining
     */
    public SubscriptionOptions setAutoReconnect(boolean isAutoReconnect) {
        this.isAutoReconnect = isAutoReconnect;
        return this;
    }

    public int getReceiveLimitMs() {
        return receiveLimitMs;
    }

    /**
     * Set the receive limit in millisecond. If no message is received within this limit time, the connection will be
     * disconnected.
     *
     * @param receiveLimitMs The receive limit in millisecond.
     */
    public void setReceiveLimitMs(int receiveLimitMs) {
        this.receiveLimitMs = receiveLimitMs;
    }

    public int getConnectionDelayOnFailure() {
        return connectionDelayOnFailure;
    }

    /**
     * If auto reconnect is enabled, specify the delay time before reconnect.
     *
     * @param connectionDelayOnFailure The delay time in second.
     */
    public void setConnectionDelayOnFailure(int connectionDelayOnFailure) {
        this.connectionDelayOnFailure = connectionDelayOnFailure;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getListenKey() {
        return listenKey;
    }

    public void setListenKey(String listenKey) {
        this.listenKey = listenKey;
    }
}
