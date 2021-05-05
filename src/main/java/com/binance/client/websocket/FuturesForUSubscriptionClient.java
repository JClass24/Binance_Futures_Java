package com.binance.client.websocket;

import com.binance.client.base.SubscriptionClient;
import com.binance.client.impl.base.BinanceApiInternalFactory;
import com.binance.client.model.event.LiquidationOrderEvent;
import com.binance.client.model.event.MarkPriceEvent;

/***
 * U本位客户端
 * The subscription client interface, it is used for subscribing any market data
 * update and account change, it is asynchronous, so you must implement the
 * SubscriptionListener interface. The server will push any update to the
 * client. if client get the update, the onReceive method will be called.
 */
public interface FuturesForUSubscriptionClient extends SubscriptionClient {

    /**
     * Create the subscription client to subscribe the update from server.
     *
     * @return The instance of synchronous client.
     */
    static FuturesForUSubscriptionClient create() {
        return create(new SubscriptionOptions());
    }

    /**
     * Create the subscription client to subscribe the update from server.
     *
     * @return The instance of synchronous client.
     */
    static FuturesForUSubscriptionClient create(String apiKey, String secretKey) {
        return create(new SubscriptionOptions(apiKey, secretKey));
    }

    /**
     * Create the subscription client to subscribe the update from server.
     *
     * @param subscriptionOptions The option of subscription connection, see {@link SubscriptionOptions}
     * @return The instance of synchronous client.
     */
    static FuturesForUSubscriptionClient create(SubscriptionOptions subscriptionOptions) {
        return BinanceApiInternalFactory.getInstance().createFuturesForUSubClient(subscriptionOptions);
    }

    /**
     * 最新标记价格 <symbol>@markPrice 或 <symbol>@markPrice@1s Subscribe mark price event. If the mark price is updated,
     * server will send the data to client and onReceive in callback will be called.
     *
     * @param symbol       The symbol, like "btcusdt".
     * @param callback     The implementation is required. onReceive will be called if receive server's update.
     * @param errorHandler The error handler will be called if subscription failed or error happen between client and
     *                     Binance server.
     */
    void subscribeMarkPriceEvent(String symbol,
                                 SubscriptionListener<MarkPriceEvent> callback, SubscriptionErrorHandler errorHandler);

    /**
     * 强平订单 Subscribe individual symbol book ticker event. If the symbol book ticker is updated, server will send the
     * data to client and onReceive in callback will be called.
     *
     * @param symbol       The symbol, like "btcusdt".
     * @param callback     The implementation is required. onReceive will be called if receive server's update.
     * @param errorHandler The error handler will be called if subscription failed or error happen between client and
     *                     Binance server.
     */
    void subscribeSymbolLiquidationOrderEvent(String symbol,
                                              SubscriptionListener<LiquidationOrderEvent> callback, SubscriptionErrorHandler errorHandler);

    /**
     * 全市场强平订单 Subscribe all market book tickers event. If the book tickers are updated, server will send the data to
     * client and onReceive in callback will be called.
     *
     * @param callback     The implementation is required. onReceive will be called if receive server's update.
     * @param errorHandler The error handler will be called if subscription failed or error happen between client and
     *                     Binance server.
     */
    void subscribeAllLiquidationOrderEvent(SubscriptionListener<LiquidationOrderEvent> callback, SubscriptionErrorHandler errorHandler);

}
