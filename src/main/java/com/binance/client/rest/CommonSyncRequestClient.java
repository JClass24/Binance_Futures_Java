package com.binance.client.rest;

import com.binance.client.impl.base.BinanceApiInternalFactory;
import com.binance.client.model.enums.TransferType;

/**
 * Synchronous request interface, invoking Binance RestAPI via synchronous method.<br> All methods in this interface
 * will be blocked until the RestAPI response.
 * <p>
 * If the invoking failed or timeout, the {@link com.binance.client.exception.BinanceApiException} will be thrown.
 */
public interface CommonSyncRequestClient {

    /**
     * Create the synchronous client. All interfaces defined in synchronous client are implemented by synchronous mode.
     *
     * @return The instance of synchronous client.
     */
    static CommonSyncRequestClient create() {
        return create("", "");
    }

    /**
     * Create the synchronous client. All interfaces defined in synchronous client are implemented by synchronous mode.
     *
     * @param apiKey    The public key applied from binance.
     * @param secretKey The private key applied from binance.
     * @return The instance of synchronous client.
     */
    static CommonSyncRequestClient create(String apiKey, String secretKey) {
        return BinanceApiInternalFactory.getInstance().createCommonSyncRequestClient(apiKey, secretKey);
    }

    /**
     * @param type
     * @param asset
     * @param amount
     * @return
     */
    String transfer(TransferType type, String asset, String amount);


}