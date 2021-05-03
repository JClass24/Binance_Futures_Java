package com.binance.client.impl.spot;

import com.binance.client.*;
import com.binance.client.constant.BinanceApiConstants;
import com.binance.client.impl.base.WebSocketStreamClientImpl;
import com.binance.client.model.event.LiquidationOrderEvent;
import com.binance.client.model.event.MarkPriceEvent;

public class SpotWebSocketStreamClientImpl extends WebSocketStreamClientImpl implements SpotSubscriptionClient {

    protected String getSubscriptionUrl() {
        return BinanceApiConstants.WS_API_BASE_URL_SPOT;
    }

    public SpotWebSocketStreamClientImpl(SubscriptionOptions options) {
        super(options);
    }

}
