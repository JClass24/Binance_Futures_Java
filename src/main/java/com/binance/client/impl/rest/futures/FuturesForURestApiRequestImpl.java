package com.binance.client.impl.rest.futures;

import com.alibaba.fastjson.JSONObject;
import com.binance.client.RequestOptions;
import com.binance.client.impl.base.BaseRestApiRequestImpl;
import com.binance.client.impl.base.RestApiRequest;
import com.binance.client.model.ResponseResult;
import com.binance.client.model.enums.*;
import com.binance.client.model.market.*;
import com.binance.client.model.trade.*;

import java.util.List;

public class FuturesForURestApiRequestImpl extends BaseRestApiRequestImpl {

    public FuturesForURestApiRequestImpl(String apiKey, String secretKey, RequestOptions options) {
        super(apiKey, secretKey, options);
    }

    public RestApiRequest<ExchangeInformation> getExchangeInformation() {
        return getExchangeInformation("/fapi/v1/exchangeInfo");
    }

    public RestApiRequest<OrderBook> getOrderBook(String symbol, Integer limit) {
        return getOrderBook(symbol, limit, "/fapi/v1/depth");
    }

    public RestApiRequest<List<Trade>> getRecentTrades(String symbol, Integer limit) {
        return getRecentTrades(symbol, limit, "/fapi/v1/trades");
    }

    public RestApiRequest<List<Trade>> getOldTrades(String symbol, Integer limit, Long fromId) {
        return getOldTrades(symbol, limit, fromId, "/fapi/v1/historicalTrades");
    }

    public RestApiRequest<List<AggregateTrade>> getAggregateTrades(String symbol, Long fromId,
                                                                   Long startTime, Long endTime, Integer limit) {
        return getAggregateTrades(symbol, fromId, startTime, endTime, limit, "/fapi/v1/aggTrades");
    }

    public RestApiRequest<List<Candlestick>> getCandlestick(String symbol, CandlestickInterval interval, Long startTime,
                                                            Long endTime, Integer limit) {
        return getCandlestick(symbol, interval, startTime, endTime, limit, "/fapi/v1/klines");
    }

    public RestApiRequest<List<MarkPrice>> getMarkPrice(String symbol) {
        return getMarkPrice(symbol, "/fapi/v1/premiumIndex");
    }

    public RestApiRequest<List<FundingRate>> getFundingRate(String symbol, Long startTime, Long endTime, Integer limit) {
        return getFundingRate(symbol, startTime, endTime, limit, "/fapi/v1/fundingRate");
    }

    public RestApiRequest<List<PriceChangeTicker>> get24hrTickerPriceChange(String symbol) {
        return get24hrTickerPriceChange(symbol, "/fapi/v1/ticker/24hr");
    }

    public RestApiRequest<List<SymbolPrice>> getSymbolPriceTicker(String symbol) {
        return getSymbolPriceTicker(symbol, "/fapi/v1/ticker/price");
    }

    public RestApiRequest<List<SymbolOrderBook>> getSymbolOrderBookTicker(String symbol) {
        return getSymbolOrderBookTicker(symbol, "/fapi/v1/ticker/bookTicker");
    }

    public RestApiRequest<List<LiquidationOrder>> getLiquidationOrders(String symbol, Long startTime, Long endTime,
                                                                       Integer limit) {
        return getLiquidationOrders(symbol, startTime, endTime, limit, "/fapi/v1/allForceOrders");
    }

    public RestApiRequest<List<Object>> postBatchOrders(String batchOrders) {
        return postBatchOrders(batchOrders, "/fapi/v1/batchOrders");
    }

    public RestApiRequest<Order> postOrder(String symbol, OrderSide side, PositionSide positionSide, OrderType orderType,
                                           TimeInForce timeInForce, String quantity, String price, String reduceOnly,
                                           String newClientOrderId, String stopPrice, WorkingType workingType, NewOrderRespType newOrderRespType) {
        return postOrder(symbol, side, positionSide, orderType, timeInForce, quantity, price, reduceOnly, newClientOrderId, stopPrice, workingType, newOrderRespType, "/fapi/v1/order");
    }

    public RestApiRequest<ResponseResult> changePositionSide(boolean dual) {
        return changePositionSide(dual, "/fapi/v1/positionSide/dual");
    }

    public RestApiRequest<ResponseResult> changeMarginType(String symbolName, String marginType) {
        return changeMarginType(symbolName, marginType, "/fapi/v1/marginType");
    }

    public RestApiRequest<JSONObject> addPositionMargin(String symbolName, int type, String amount, PositionSide positionSide) {
        return addPositionMargin(symbolName, type, amount, positionSide, "/fapi/v1/positionMargin");
    }

    public RestApiRequest<List<WalletDeltaLog>> getPositionMarginHistory(String symbolName, int type, long startTime, long endTime, int limit) {
        return getPositionMarginHistory(symbolName, type, startTime, endTime, limit, "/fapi/v1/positionMargin/history");
    }


    public RestApiRequest<JSONObject> getPositionSide() {
        return getPositionSide("/fapi/v1/positionSide/dual");
    }

    public RestApiRequest<Order> cancelOrder(String symbol, Long orderId, String origClientOrderId) {
        return cancelOrder(symbol, orderId, origClientOrderId, "/fapi/v1/order");
    }

    public RestApiRequest<ResponseResult> cancelAllOpenOrder(String symbol) {
        return cancelAllOpenOrder(symbol, "/fapi/v1/allOpenOrders");
    }

    public RestApiRequest<List<Object>> batchCancelOrders(String symbol, String orderIdList, String origClientOrderIdList) {
        return batchCancelOrders(symbol, orderIdList, origClientOrderIdList, "/fapi/v1/batchOrders");
    }

    public RestApiRequest<Order> getOrder(String symbol, Long orderId, String origClientOrderId) {
        return getOrder(symbol, orderId, origClientOrderId, "/fapi/v1/order");
    }

    public RestApiRequest<List<Order>> getOpenOrders(String symbol) {
        return getOpenOrders(symbol, "/fapi/v1/openOrders");
    }

    public RestApiRequest<List<Order>> getAllOrders(String symbol, Long orderId, Long startTime, Long endTime, Integer limit) {
        return getAllOrders(symbol, orderId, startTime, endTime, limit, "/fapi/v1/allOrders");
    }

    public RestApiRequest<List<AccountBalance>> getBalance() {
        return getBalance("/fapi/v1/balance");
    }

    public RestApiRequest<AccountInformation> getAccountInformation() {
        return getAccountInformation("/fapi/v1/account");
    }

    public RestApiRequest<Leverage> changeInitialLeverage(String symbol, Integer leverage) {
        return changeInitialLeverage(symbol, leverage, "/fapi/v1/leverage");
    }

    public RestApiRequest<List<PositionRisk>> getPositionRisk() {
        return getPositionRisk("/fapi/v1/positionRisk");
    }

    public RestApiRequest<List<MyTrade>> getAccountTrades(String symbol, Long startTime, Long endTime,
                                                          Long fromId, Integer limit) {
        return getAccountTrades(symbol, startTime, endTime, fromId, limit, "/fapi/v1/userTrades");
    }

    public RestApiRequest<List<Income>> getIncomeHistory(String symbol, IncomeType incomeType, Long startTime, Long endTime,
                                                         Integer limit) {
        return getIncomeHistory(symbol, incomeType, startTime, endTime, limit, "/fapi/v1/income");
    }

    public RestApiRequest<String> startUserDataStream() {
        return startUserDataStream("/fapi/v1/listenKey");
    }

    public RestApiRequest<String> keepUserDataStream(String listenKey) {
        return keepUserDataStream(listenKey, "/fapi/v1/listenKey");
    }

    public RestApiRequest<String> closeUserDataStream(String listenKey) {
        return closeUserDataStream(listenKey, "/fapi/v1/listenKey");
    }

    public RestApiRequest<List<OpenInterestStat>> getOpenInterestStat(String symbol, PeriodType period, Long startTime, Long endTime, Integer limit) {
        return getOpenInterestStat(symbol, period, startTime, endTime, limit, "/futures/data/openInterestHist");
    }

    public RestApiRequest<List<CommonLongShortRatio>> getTopTraderAccountRatio(String symbol, PeriodType period, Long startTime, Long endTime, Integer limit) {
        return getTopTraderAccountRatio(symbol, period, startTime, endTime, limit, "/futures/data/topLongShortAccountRatio");
    }

    public RestApiRequest<List<CommonLongShortRatio>> getTopTraderPositionRatio(String symbol, PeriodType period, Long startTime, Long endTime, Integer limit) {
        return getTopTraderPositionRatio(symbol, period, startTime, endTime, limit, "/futures/data/topLongShortPositionRatio");
    }

    public RestApiRequest<List<CommonLongShortRatio>> getGlobalAccountRatio(String symbol, PeriodType period, Long startTime, Long endTime, Integer limit) {
        return getGlobalAccountRatio(symbol, period, startTime, endTime, limit, "/futures/data/globalLongShortAccountRatio");
    }

    public RestApiRequest<List<TakerLongShortStat>> getTakerLongShortRatio(String symbol, PeriodType period, Long startTime, Long endTime, Integer limit) {
        return getTakerLongShortRatio(symbol, period, startTime, endTime, limit, "/futures/data/takerlongshortRatio");
    }
}
