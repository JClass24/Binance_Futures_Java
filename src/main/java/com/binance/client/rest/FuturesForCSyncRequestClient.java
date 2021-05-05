package com.binance.client.rest;

import com.binance.client.base.SyncRequestClient;
import com.binance.client.impl.base.BinanceApiInternalFactory;

/**
 * Synchronous request interface, invoking Binance RestAPI via synchronous method.<br> All methods in this interface
 * will be blocked until the RestAPI response.
 * <p>
 * If the invoking failed or timeout, the {@link com.binance.client.exception.BinanceApiException} will be thrown.
 */
public interface FuturesForCSyncRequestClient extends SyncRequestClient {

    /**
     * Create the synchronous client. All interfaces defined in synchronous client are implemented by synchronous mode.
     *
     * @return The instance of synchronous client.
     */
    static FuturesForCSyncRequestClient create() {
        return create("", "");
    }

    /**
     * Create the synchronous client. All interfaces defined in synchronous client are implemented by synchronous mode.
     *
     * @param apiKey    The public key applied from binance.
     * @param secretKey The private key applied from binance.
     * @return The instance of synchronous client.
     */
    static FuturesForCSyncRequestClient create(String apiKey, String secretKey) {
        return BinanceApiInternalFactory.getInstance().createFuturesForCSyncRequestClient(apiKey, secretKey);
    }
}