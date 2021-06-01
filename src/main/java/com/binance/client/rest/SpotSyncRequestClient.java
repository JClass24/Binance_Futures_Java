package com.binance.client.rest;

import com.binance.client.base.SyncRequestClient;
import com.binance.client.impl.base.BinanceApiInternalFactory;
import com.binance.client.model.enums.NewOrderRespType;
import com.binance.client.model.enums.OrderSide;
import com.binance.client.model.enums.OrderType;
import com.binance.client.model.enums.TimeInForce;
import com.binance.client.model.trade.Order;
import com.binance.client.model.trade.SpotAccountInformation;

/**
 * Synchronous request interface, invoking Binance RestAPI via synchronous method.<br> All methods in this interface
 * will be blocked until the RestAPI response.
 * <p>
 * If the invoking failed or timeout, the {@link com.binance.client.exception.BinanceApiException} will be thrown.
 */
public interface SpotSyncRequestClient extends SyncRequestClient {

    /**
     * Create the synchronous client. All interfaces defined in synchronous client are implemented by synchronous mode.
     *
     * @return The instance of synchronous client.
     */
    static SpotSyncRequestClient create() {
        return create("", "");
    }

    /**
     * Create the synchronous client. All interfaces defined in synchronous client are implemented by synchronous mode.
     *
     * @param apiKey    The public key applied from binance.
     * @param secretKey The private key applied from binance.
     * @return The instance of synchronous client.
     */
    static SpotSyncRequestClient create(String apiKey, String secretKey) {
        return BinanceApiInternalFactory.getInstance().createSpotSyncRequestClient(apiKey, secretKey);
    }

    Order postOrder(String symbol, OrderSide side, OrderType orderType,
                    TimeInForce timeInForce, String quantity, String quoteOrderQty, String price,
                    String newClientOrderId, String stopPrice, String icebergQty, NewOrderRespType newOrderRespType);

    /**
     * Get current account information.
     *
     * @return Current account information.
     */
    SpotAccountInformation getAccountInformation();


}