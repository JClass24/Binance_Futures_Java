package com.binance.client.impl.websocket.spot;

import com.binance.client.constant.BinanceApiConstants;
import com.binance.client.impl.base.WebSocketStreamClientImpl;
import com.binance.client.websocket.SpotSubscriptionClient;
import com.binance.client.websocket.SubscriptionOptions;

public class SpotWebSocketStreamClientImpl extends WebSocketStreamClientImpl implements SpotSubscriptionClient {

    public SpotWebSocketStreamClientImpl(SubscriptionOptions options) {
        super(options);
    }

    protected String getSubscriptionUrl() {
        return BinanceApiConstants.WS_API_BASE_URL_SPOT;
    }

}
