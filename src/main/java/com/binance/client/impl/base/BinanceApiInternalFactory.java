package com.binance.client.impl.base;

import com.binance.client.RequestOptions;
import com.binance.client.constant.BinanceApiConstants;
import com.binance.client.impl.rest.common.CommonRestApiRequestImpl;
import com.binance.client.impl.rest.common.CommonSyncRequestImpl;
import com.binance.client.impl.rest.futures.FuturesForCRestApiRequestImpl;
import com.binance.client.impl.rest.futures.FuturesForCSyncRequestImpl;
import com.binance.client.impl.rest.futures.FuturesForURestApiRequestImpl;
import com.binance.client.impl.rest.futures.FuturesForUSyncRequestImpl;
import com.binance.client.impl.rest.spot.SpotRestApiRequestImpl;
import com.binance.client.impl.rest.spot.SpotSyncRequestImpl;
import com.binance.client.impl.websocket.futures.FuturesForCWebSocketStreamClientImpl;
import com.binance.client.impl.websocket.futures.FuturesForUWebSocketStreamClientImpl;
import com.binance.client.impl.websocket.spot.SpotWebSocketStreamClientImpl;
import com.binance.client.rest.CommonSyncRequestClient;
import com.binance.client.rest.FuturesForCSyncRequestClient;
import com.binance.client.rest.FuturesForUSyncRequestClient;
import com.binance.client.rest.SpotSyncRequestClient;
import com.binance.client.websocket.FuturesForCSubscriptionClient;
import com.binance.client.websocket.FuturesForUSubscriptionClient;
import com.binance.client.websocket.SpotSubscriptionClient;
import com.binance.client.websocket.SubscriptionOptions;

public final class BinanceApiInternalFactory {

    private static final BinanceApiInternalFactory instance = new BinanceApiInternalFactory();

    private BinanceApiInternalFactory() {
    }

    public static BinanceApiInternalFactory getInstance() {
        return instance;
    }

    public FuturesForUSyncRequestClient createFuturesForUSyncRequestClient(String apiKey, String secretKey) {
        RequestOptions options = new RequestOptions(BinanceApiConstants.API_BASE_URL_FUTURES_U);
        FuturesForURestApiRequestImpl requestImpl = new FuturesForURestApiRequestImpl(apiKey, secretKey, options);
        return new FuturesForUSyncRequestImpl(requestImpl);
    }

    public FuturesForCSyncRequestClient createFuturesForCSyncRequestClient(String apiKey, String secretKey) {
        RequestOptions options = new RequestOptions(BinanceApiConstants.API_BASE_URL_FUTURES_C);
        FuturesForCRestApiRequestImpl requestImpl = new FuturesForCRestApiRequestImpl(apiKey, secretKey, options);
        return new FuturesForCSyncRequestImpl(requestImpl);
    }

    public SpotSyncRequestClient createSpotSyncRequestClient(String apiKey, String secretKey) {
        RequestOptions options = new RequestOptions(BinanceApiConstants.API_BASE_URL_SPOT);
        SpotRestApiRequestImpl requestImpl = new SpotRestApiRequestImpl(apiKey, secretKey, options);
        return new SpotSyncRequestImpl(requestImpl);
    }

    public CommonSyncRequestClient createCommonSyncRequestClient(String apiKey, String secretKey) {
        RequestOptions options = new RequestOptions(BinanceApiConstants.API_BASE_URL_SPOT);
        CommonRestApiRequestImpl requestImpl = new CommonRestApiRequestImpl(apiKey, secretKey, options);
        return new CommonSyncRequestImpl(requestImpl);
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
