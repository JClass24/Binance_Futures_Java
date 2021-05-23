package com.binance.client.base;

import com.binance.client.model.event.*;
import com.binance.client.model.market.BookDepth;
import com.binance.client.model.market.CandleConfig;
import com.binance.client.model.user.UserDataUpdateEvent;
import com.binance.client.websocket.SubscriptionListener;

import java.util.List;

/***
 * The subscription client interface, it is used for subscribing any market data
 * update and account change, it is asynchronous, so you must implement the
 * SubscriptionListener interface. The server will push any update to the
 * client. if client get the update, the onReceive method will be called.
 */
public interface SubscriptionClient {
    /**
     * Unsubscribe all subscription.
     */
    void unsubscribeAll();

    /**
     * 最新合约价格 aggTrade中的价格'p'或ticker/miniTicker中的价格'c'均可以作为最新成交价。
     * <p>
     * 同一价格、同一方向、同一时间(100ms计算)的trade会被聚合为一条. Subscribe aggregate trade event. If the aggregate trade is updated, server
     * will send the data to client and onReceive in callback will be called.
     *
     * @param symbols  The symbol, like "btcusdt".
     * @param callback The implementation is required. onReceive will be called if receive server's update.
     */
    void subscribeAggregateTradeEvent(List<String> symbols,
                                      SubscriptionListener<AggregateTradeEvent> callback);

    /**
     * Subscribe candlestick event. If the candlestick is updated, server will send the data to client and onReceive in
     * callback will be called.
     *
     * @param CandleConfigs  The candles.
     * @param callback The implementation is required. onReceive will be called if receive server's update.
     */
    void subscribeCandlestickEvent(List<CandleConfig> CandleConfigs,
                                   SubscriptionListener<CandlestickEvent> callback);

    /**
     * Subscribe individual symbol mini ticker event. If the symbol mini ticker is updated, server will send the data to
     * client and onReceive in callback will be called.
     *
     * @param symbols  The symbol, like "btcusdt".
     * @param callback The implementation is required. onReceive will be called if receive server's update.
     */
    void subscribeSymbolMiniTickerEvent(List<String> symbols,
                                        SubscriptionListener<SymbolMiniTickerEvent> callback);

    /**
     * Subscribe all market mini tickers event. If the mini tickers are updated, server will send the data to client and
     * onReceive in callback will be called.
     *
     * @param callback The implementation is required. onReceive will be called if receive server's update.
     */
    void subscribeAllMiniTickerEvent(SubscriptionListener<List<SymbolMiniTickerEvent>> callback);

    /**
     * Subscribe individual symbol ticker event. If the symbol ticker is updated, server will send the data to client
     * and onReceive in callback will be called.
     *
     * @param symbols  The symbol, like "btcusdt".
     * @param callback The implementation is required. onReceive will be called if receive server's update.
     */
    void subscribeSymbolTickerEvent(List<String> symbols,
                                    SubscriptionListener<SymbolTickerEvent> callback);

    /**
     * Subscribe all market tickers event. If the tickers are updated, server will send the data to client and onReceive
     * in callback will be called.
     *
     * @param callback The implementation is required. onReceive will be called if receive server's update.
     */
    void subscribeAllTickerEvent(SubscriptionListener<List<SymbolTickerEvent>> callback);

    /**
     * Subscribe individual symbol book ticker event. If the symbol book ticker is updated, server will send the data to
     * client and onReceive in callback will be called.
     *
     * @param symbols  The symbol, like "btcusdt".
     * @param callback The implementation is required. onReceive will be called if receive server's update.
     */
    void subscribeSymbolBookTickerEvent(List<String> symbols,
                                        SubscriptionListener<SymbolBookTickerEvent> callback);

    /**
     * Subscribe all market book tickers event. If the book tickers are updated, server will send the data to client and
     * onReceive in callback will be called.
     *
     * @param callback The implementation is required. onReceive will be called if receive server's update.
     */
    void subscribeAllBookTickerEvent(SubscriptionListener<SymbolBookTickerEvent> callback);

    /**
     * Subscribe partial book depth event. If the book depth is updated, server will send the data to client and
     * onReceive in callback will be called.
     *
     * @param bookDepths The bookDepths, like "btcusdt".
     * @param callback   The implementation is required. onReceive will be called if receive server's update.
     */
    void subscribeBookDepthEvent(List<BookDepth> bookDepths,
                                 SubscriptionListener<OrderBookEvent> callback);

    /**
     * Subscribe diff depth event. If the book depth is updated, server will send the data to client and onReceive in
     * callback will be called.
     *
     * @param symbols  The symbol, like "btcusdt".
     * @param callback The implementation is required. onReceive will be called if receive server's update.
     */
    void subscribeDiffDepthEvent(List<String> symbols,
                                 SubscriptionListener<OrderBookEvent> callback);

    /**
     * Subscribe user data event. If the user data is updated, server will send the data to client and onReceive in
     * callback will be called.
     *
     * @param callback The implementation is required. onReceive will be called if receive server's update.
     */
    void subscribeUserDataEvent(SubscriptionListener<UserDataUpdateEvent> callback);


}
