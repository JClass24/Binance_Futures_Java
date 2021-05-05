package com.binance.client.impl.rest.spot;

import com.binance.client.impl.base.RestApiInvoker;
import com.binance.client.model.enums.*;
import com.binance.client.model.market.*;
import com.binance.client.model.trade.FuturesOrder;
import com.binance.client.model.trade.MyTrade;
import com.binance.client.model.trade.SpotAccountInformation;
import com.binance.client.model.trade.SpotOrder;
import com.binance.client.rest.SpotSyncRequestClient;

import java.util.List;

public class SpotSyncRequestImpl implements SpotSyncRequestClient {

    private final SpotRestApiRequestImpl requestImpl;

    public SpotSyncRequestImpl(SpotRestApiRequestImpl requestImpl) {
        this.requestImpl = requestImpl;
    }

    @Override
    public ExchangeInformation getExchangeInformation() {
        return RestApiInvoker.callSync(requestImpl.getExchangeInformation());
    }

    @Override
    public OrderBook getOrderBook(String symbol, Integer limit) {
        return RestApiInvoker.callSync(requestImpl.getOrderBook(symbol, limit));
    }

    @Override
    public List<Trade> getRecentTrades(String symbol, Integer limit) {
        return RestApiInvoker.callSync(requestImpl.getRecentTrades(symbol, limit));
    }

    @Override
    public List<Trade> getOldTrades(String symbol, Integer limit, Long fromId) {
        return RestApiInvoker.callSync(requestImpl.getOldTrades(symbol, limit, fromId));
    }

    @Override
    public List<AggregateTrade> getAggregateTrades(String symbol, Long fromId, Long startTime,
                                                   Long endTime, Integer limit) {
        return RestApiInvoker.callSync(requestImpl.getAggregateTrades(symbol, fromId, startTime, endTime, limit));
    }

    @Override
    public List<Candlestick> getCandlestick(String symbol, CandlestickInterval interval, Long startTime,
                                            Long endTime, Integer limit) {
        return RestApiInvoker.callSync(requestImpl.getCandlestick(symbol, interval, startTime, endTime, limit));
    }

    @Override
    public List<PriceChangeTicker> get24hrTickerPriceChange(String symbol) {
        return RestApiInvoker.callSync(requestImpl.get24hrTickerPriceChange(symbol));
    }

    @Override
    public List<SymbolPrice> getSymbolPriceTicker(String symbol) {
        return RestApiInvoker.callSync(requestImpl.getSymbolPriceTicker(symbol));
    }

    @Override
    public List<SymbolOrderBook> getSymbolOrderBookTicker(String symbol) {
        return RestApiInvoker.callSync(requestImpl.getSymbolOrderBookTicker(symbol));
    }

    @Override
    public SpotOrder postOrder(String symbol, OrderSide side, OrderType orderType,
                               TimeInForce timeInForce, String quantity, String quoteOrderQty, String price,
                               String newClientOrderId, String stopPrice, String icebergQty, NewOrderRespType newOrderRespType) {
        return RestApiInvoker.callSync(requestImpl.postOrder(symbol, side, orderType,
                timeInForce, quantity, quoteOrderQty, price,
                newClientOrderId, stopPrice, icebergQty, newOrderRespType));
    }

    @Override
    public FuturesOrder cancelOrder(String symbol, Long orderId, String origClientOrderId) {
        return RestApiInvoker.callSync(requestImpl.cancelOrder(symbol, orderId, origClientOrderId));
    }

    @Override
    public FuturesOrder getOrder(String symbol, Long orderId, String origClientOrderId) {
        return RestApiInvoker.callSync(requestImpl.getOrder(symbol, orderId, origClientOrderId));
    }

    @Override
    public List<FuturesOrder> getOpenOrders(String symbol) {
        return RestApiInvoker.callSync(requestImpl.getOpenOrders(symbol));
    }

    @Override
    public List<FuturesOrder> getAllOrders(String symbol, Long orderId, Long startTime, Long endTime, Integer limit) {
        return RestApiInvoker.callSync(requestImpl.getAllOrders(symbol, orderId, startTime, endTime, limit));
    }

    @Override
    public SpotAccountInformation getAccountInformation() {
        return RestApiInvoker.callSync(requestImpl.getAccountInformation());
    }

    @Override
    public List<MyTrade> getAccountTrades(String symbol, Long startTime, Long endTime, Long fromId, Integer limit) {
        return RestApiInvoker.callSync(requestImpl.getAccountTrades(symbol, startTime, endTime, fromId, limit));
    }

    @Override
    public String startUserDataStream() {
        return RestApiInvoker.callSync(requestImpl.startUserDataStream());
    }

    @Override
    public String keepUserDataStream(String listenKey) {
        return RestApiInvoker.callSync(requestImpl.keepUserDataStream(listenKey));
    }

    @Override
    public String closeUserDataStream(String listenKey) {
        return RestApiInvoker.callSync(requestImpl.closeUserDataStream(listenKey));
    }
}
