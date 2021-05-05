package com.binance.client.rest;

import com.binance.client.base.FuturesSyncRequestClient;
import com.binance.client.impl.base.BinanceApiInternalFactory;
import com.binance.client.model.enums.PeriodType;
import com.binance.client.model.market.TakerLongShortStat;

import java.util.List;

/**
 * Synchronous request interface, invoking Binance RestAPI via synchronous method.<br> All methods in this interface
 * will be blocked until the RestAPI response.
 * <p>
 * If the invoking failed or timeout, the {@link com.binance.client.exception.BinanceApiException} will be thrown.
 */
public interface FuturesForUSyncRequestClient extends FuturesSyncRequestClient {

    /**
     * Create the synchronous client. All interfaces defined in synchronous client are implemented by synchronous mode.
     *
     * @return The instance of synchronous client.
     */
    static FuturesForUSyncRequestClient create() {
        return create("", "");
    }

    /**
     * Create the synchronous client. All interfaces defined in synchronous client are implemented by synchronous mode.
     *
     * @param apiKey    The public key applied from binance.
     * @param secretKey The private key applied from binance.
     * @return The instance of synchronous client.
     */
    static FuturesForUSyncRequestClient create(String apiKey, String secretKey) {
        return BinanceApiInternalFactory.getInstance().createFuturesForUSyncRequestClient(apiKey, secretKey);
    }

    /**
     * Taker Long/Short Ratio (MARKET DATA)
     *
     * @return Taker Long/Short Ratio.
     */
    List<TakerLongShortStat> getTakerLongShortRatio(String symbol, PeriodType period, Long startTime, Long endTime, Integer limit);
}