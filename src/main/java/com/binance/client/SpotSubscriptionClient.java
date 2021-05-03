package com.binance.client;

import com.binance.client.base.SubscriptionClient;
import com.binance.client.impl.base.BinanceApiInternalFactory;
import com.binance.client.model.event.LiquidationOrderEvent;
import com.binance.client.model.event.MarkPriceEvent;

/***
 * 现货客户端
 * The subscription client interface, it is used for subscribing any market data
 * update and account change, it is asynchronous, so you must implement the
 * SubscriptionListener interface. The server will push any update to the
 * client. if client get the update, the onReceive method will be called.
 */
public interface SpotSubscriptionClient extends SubscriptionClient {

    /**
     * Create the subscription client to subscribe the update from server.
     *
     * @return The instance of synchronous client.
     */
    static SpotSubscriptionClient create() {
        return create(new SubscriptionOptions());
    }

    /**
     * Create the subscription client to subscribe the update from server.
     *
     * @param subscriptionOptions The option of subscription connection, see {@link SubscriptionOptions}
     * @return The instance of synchronous client.
     */
    static SpotSubscriptionClient create(SubscriptionOptions subscriptionOptions) {
        return BinanceApiInternalFactory.getInstance().createSpotSubClient(subscriptionOptions);
    }
}
