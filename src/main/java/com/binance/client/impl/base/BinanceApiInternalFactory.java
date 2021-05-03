package com.binance.client.impl.base;

import com.binance.client.*;
import com.binance.client.base.SubscriptionClient;
import com.binance.client.impl.futures.FuturesForCWebSocketStreamClientImpl;
import com.binance.client.impl.futures.FuturesForUWebSocketStreamClientImpl;
import com.binance.client.impl.spot.SpotWebSocketStreamClientImpl;

public final class BinanceApiInternalFactory {

    private static final BinanceApiInternalFactory instance = new BinanceApiInternalFactory();

    private BinanceApiInternalFactory() {
    }

    public static BinanceApiInternalFactory getInstance() {
        return instance;
    }

    public SyncRequestClient createSyncRequestClient(String apiKey, String secretKey, RequestOptions options) {
        RestApiRequestImpl requestImpl = new RestApiRequestImpl(apiKey, secretKey, options);
        return new SyncRequestImpl(requestImpl);
    }

    public FuturesForCSubscriptionClient createFuturesForCSubClient(SubscriptionOptions options) {
        FuturesForCSubscriptionClient webSocketStreamClient = new FuturesForCWebSocketStreamClientImpl(options);
        return webSocketStreamClient;
    }

    public FuturesForUSubscriptionClient createFuturesForUSubClient(SubscriptionOptions options) {
        FuturesForUSubscriptionClient webSocketStreamClient = new FuturesForUWebSocketStreamClientImpl(options);
        return webSocketStreamClient;
    }

    public SpotSubscriptionClient createSpotSubClient(SubscriptionOptions options) {
        SpotSubscriptionClient webSocketStreamClient = new SpotWebSocketStreamClientImpl(options);
        return webSocketStreamClient;
    }
}
